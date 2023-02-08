package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.utils.extensions.bounds
import com.beardness.yourchordsru.utils.extensions.invert
import com.beardness.yourchordsru.utils.html.IHtmlBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongScreenViewModel @Inject constructor(
    private val songsCore: ISongsCore,
    private val navigator: INavigator,
    private val htmlBuilder: IHtmlBuilder,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), ISongScreenViewModel {

    private val _authorId = MutableStateFlow<Int>(value = -1)
    private val _songId = MutableStateFlow<Int>(value = -1)

    private val _authorName = MutableStateFlow<String>(value = "")
    override val authorName = _authorName.asStateFlow()

    private val _songTitle = MutableStateFlow<String>(value = "")
    override val songTitle = _songTitle.asStateFlow()

    private val _backgroundColor = MutableStateFlow<Color>(value = Color.Transparent)
    override val backgroundColor = _backgroundColor.asStateFlow()

    private val _textColor = MutableStateFlow<Color>(value = Color.Transparent)
    override val textColor = _textColor.asStateFlow()

    private val _chordsColor = MutableStateFlow<Color>(value = Color.Transparent)
    override val chordsColor = _chordsColor.asStateFlow()

    private val _chordsRaw = MutableStateFlow<String>(value = "")

    private val _chords = MutableStateFlow<String>(value = "")
    override val chords = _chords.asStateFlow()

    private val _isToolbarExpanded = MutableStateFlow<Boolean>(value = false)
    override val isToolbarExpanded = _isToolbarExpanded.asStateFlow()

    private val _textSize = MutableStateFlow<Int>(value = DEFAULT_FONT_SIZE_PX)
    override val textSize = _textSize.asStateFlow()

    companion object {
        const val DEFAULT_FONT_SIZE_PX = 12
        const val MAX_FONT_SIZE_PX = 24
        const val MIN_FONT_SIZE_PX = 8
    }

    override fun load(
        authorId: Int?,
        songId: Int?,
        backgroundColor: Color,
        textColor: Color,
        chordsColor: Color,
    ) {
        authorId ?: return
        songId ?: return

        ioCoroutineScope.launch {
            val song =
                songsCore
                    .song(
                        authorId = authorId,
                        songId = songId,
                    )
                    ?.viewDto()
                    ?: return@launch

            _authorId.emit(value = authorId)
            _songId.emit(value = songId)

            _authorName.emit(value = song.authorName)
            _songTitle.emit(value = song.title)

            _backgroundColor.emit(value = backgroundColor)
            _textColor.emit(value = textColor)
            _chordsColor.emit(value = chordsColor)

            val chords =
                song.chords

            _chordsRaw.emit(value = chords)

            val textSizePx = _textSize.value

            val htmlChords = htmlBuilder.html(
                content = chords,
                backgroundColor = backgroundColor,
                textColor = textColor,
                textSizePx = textSizePx,
                chordsColor = chordsColor,
            )

            _chords.emit(value = htmlChords)
        }
    }

    override fun navigateBack() {
        navigator.back()
    }

    override fun navigateChords() {
        val authorId = _authorId.value
        val songId = _songId.value
        navigator.chords(authorId = authorId, songId = songId)
    }

    override fun expandToolbar() {
        ioCoroutineScope.launch {
            val newValue =
                _isToolbarExpanded
                    .value
                    .invert()

            _isToolbarExpanded.emit(value = newValue)
        }
    }

    override fun textIncrease() {
        textSizePxUpdate(difference = 2)
    }

    override fun textDecrease() {
        textSizePxUpdate(difference = -2)
    }

    override fun textReset() {
        ioCoroutineScope.launch {
            _textSize.emit(value = DEFAULT_FONT_SIZE_PX)
            reload()
        }
    }

    private fun reload() {
        ioCoroutineScope.launch {
            val chords = _chordsRaw.value
            val backgroundColor = _backgroundColor.value
            val textColor = _textColor.value
            val chordsColor = _chordsColor.value
            val textSizePx = _textSize.value

            val htmlChords = htmlBuilder.html(
                content = chords,
                backgroundColor = backgroundColor,
                textColor = textColor,
                textSizePx = textSizePx,
                chordsColor = chordsColor,
            )

            _chords.emit(value = htmlChords)
        }
    }

    private fun textSizePxUpdate(difference: Int) {
        ioCoroutineScope.launch {
            val newTextSize =
                _textSize
                    .value + difference

            val boundedTextSize =
                newTextSize
                    .bounds(
                        max = MAX_FONT_SIZE_PX,
                        min = MIN_FONT_SIZE_PX,
                    )

            _textSize.emit(value = boundedTextSize)
            reload()
        }
    }
}