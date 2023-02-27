package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.settings.viewDto
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.utils.extensions.bounds
import com.beardness.yourchordsru.utils.extensions.invert
import com.beardness.yourchordsru.utils.html.IHtmlBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongScreenViewModel @Inject constructor(
    private val songsCore: ISongsCore,
    private val settingsCore: ISettingsCore,
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

    override val chords: Flow<String> =
        combine(
            settingsCore.chordsView,
            _chordsRaw
        ) { chordsView, chordsRaw ->

            _backgroundColor.emit(value = chordsView.backgroundColor)
            _textColor.emit(value = chordsView.textColor)
            _chordsColor.emit(value = chordsView.chordsColor)
            _textSize.emit(value = chordsView.fontSize)

            val htmlChords = htmlBuilder.html(
                content = chordsRaw,
                backgroundColor = chordsView.backgroundColor,
                textColor = chordsView.textColor,
                textSizePx = chordsView.fontSize,
                chordsColor = chordsView.chordsColor,
            )

            htmlChords
        }

    private val _isToolbarExpanded = MutableStateFlow<Boolean>(value = false)
    override val isToolbarExpanded = _isToolbarExpanded.asStateFlow()

    private val _initialTextSize = MutableStateFlow<Int>(value = 0)
    override val initialTextSize = _initialTextSize.asStateFlow()

    private val _textSize = MutableStateFlow<Int>(value = 0)
    override val textSize = _textSize.asStateFlow()

    init {
        collectChordsView()
    }

    override fun load(
        authorId: Int?,
        songId: Int?,
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

            _chordsRaw.emit(value = song.chords)
        }
    }

    override fun navigateBack() {
        navigator.back()
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
            _textSize.emit(value = _initialTextSize.value)
        }
    }

    private fun collectChordsView() {
        ioCoroutineScope.launch {
            settingsCore.chordsView.collect { chordsViewCoreDto ->
                val chordsViewViewDto = chordsViewCoreDto.viewDto()

                _backgroundColor.emit(value = chordsViewViewDto.backgroundColor)
                _textColor.emit(value = chordsViewViewDto.textColor)
                _chordsColor.emit(value = chordsViewViewDto.chordsColor)
                _initialTextSize.emit(value = chordsViewViewDto.fontSize)
                _textSize.emit(value = chordsViewViewDto.fontSize)
            }
        }
    }

    private fun textSizePxUpdate(difference: Int) {
        ioCoroutineScope.launch {
            val newTextSize =
                _textSize
                    .value + difference

            val boundedTextSize =
                newTextSize
                    .bounds()

            _textSize.emit(value = boundedTextSize)
        }
    }

    override fun changeBackgroundColor(color: Color) {
        ioCoroutineScope.launch {
            settingsCore.setupBackgroundColor(color = color)
        }
    }

    override fun changeTextColor(color: Color) {
        ioCoroutineScope.launch {
            settingsCore.setupTextColor(color = color)
        }
    }

    override fun changeChordsColor(color: Color) {
        ioCoroutineScope.launch {
            settingsCore.setupChordsColor(color = color)
        }
    }
}