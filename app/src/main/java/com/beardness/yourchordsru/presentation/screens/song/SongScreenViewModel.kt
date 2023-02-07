package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.utils.common.invert
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

    private val _authorName = MutableStateFlow<String>(value = "")
    override val authorName = _authorName.asStateFlow()

    private val _songTitle = MutableStateFlow<String>(value = "")
    override val songTitle = _songTitle.asStateFlow()

    private val _chords = MutableStateFlow<String>(value = "")
    override val chords = _chords.asStateFlow()

    private val _isToolbarExpanded = MutableStateFlow<Boolean>(value = false)
    override val isToolbarExpanded = _isToolbarExpanded.asStateFlow()

    override fun load(
        authorId: Int?,
        songId: Int?,
        backgroundColor: Color,
        textColor: Color,
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

            val chords =
                song.chords

            val htmlChords = htmlBuilder.html(
                content = chords,
                backgroundColor = backgroundColor,
                textColor = textColor,
            )

            _authorName.emit(value = song.authorName)
            _songTitle.emit(value = song.title)
            _chords.emit(value = htmlChords)
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
}