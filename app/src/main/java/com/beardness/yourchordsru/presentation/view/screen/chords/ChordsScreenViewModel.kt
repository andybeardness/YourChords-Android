package com.beardness.yourchordsru.presentation.view.screen.chords

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.chords.ChordsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCaseProtocol
import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import com.beardness.yourchordsru.utils.html.IHtmlBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChordsScreenViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCaseProtocol,
    private val songsUseCase: SongsUseCaseProtocol,
    private val chordsUseCase: ChordsUseCaseProtocol,
    private val htmlBuilder: IHtmlBuilder,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), ChordsScreenViewModelProtocol {

    private val _authorId = MutableStateFlow<Int?>(value = null)
    private val _songId = MutableStateFlow<Int?>(value = null)
    private val _fontSizePx = MutableStateFlow(value = 14)
    private val _viewMode = MutableStateFlow(value = ChordsViewMode.LIGHT)

    override val authorName =
        _authorId
            .filterNotNull()
            .map { authorId ->
                authorsUseCase
                    .author(authorId = authorId)
                    ?.name
            }
            .filterNotNull()

    override val songTitle: Flow<String> =
        combine(
            _authorId,
            _songId,
        ) { authorId, songId ->
            authorId ?: return@combine null
            songId ?: return@combine null

            songsUseCase
                .song(
                    authorId = authorId,
                    songId = songId,
                )
                ?.title
        }.filterNotNull()

    override val chords =
        combine(
            _authorId,
            _songId,
            _fontSizePx,
            _viewMode,
        ) { authorId, songId, fontSizePx, viewMode ->
            authorId ?: return@combine null
            songId ?: return@combine null

            val rawChords =
                chordsUseCase
                    .chords(authorId = authorId, songId = songId)
                    ?: return@combine null

            val backgroundColor = when (viewMode) {
                ChordsViewMode.LIGHT -> Color.White
                ChordsViewMode.DARK -> Color.Black
            }

            val textColor = when (viewMode) {
                ChordsViewMode.LIGHT -> Color.Black
                ChordsViewMode.DARK -> Color.White
            }

            val chordsColor = when (viewMode) {
                ChordsViewMode.LIGHT -> Color.Blue
                ChordsViewMode.DARK -> Color.Yellow
            }

            htmlBuilder.html(
                content = rawChords,
                backgroundColor = backgroundColor,
                textColor = textColor,
                chordsColor = chordsColor,
                textSizePx = fontSizePx,
            )
        }.filterNotNull()

    override fun setup(authorId: Int, songId: Int) {
        ioCoroutineScope.launch {
            _authorId.emit(value = authorId)
            _songId.emit(value = songId)
        }
    }

    override fun increaseText() {
        ioCoroutineScope.launch {
            if (_fontSizePx.value < 24) {
                val newFontSizePx = _fontSizePx.value + 2
                _fontSizePx.emit(value = newFontSizePx)
            }
        }
    }

    override fun decreaseText() {
        ioCoroutineScope.launch {
            if (_fontSizePx.value > 12) {
                val newFontSizePx = _fontSizePx.value - 2
                _fontSizePx.emit(value = newFontSizePx)
            }
        }
    }

    override fun swapViewMode() {
        ioCoroutineScope.launch {
            val newViewMode = when (_viewMode.value) {
                ChordsViewMode.LIGHT -> ChordsViewMode.DARK
                ChordsViewMode.DARK -> ChordsViewMode.LIGHT
            }

            _viewMode.emit(value = newViewMode)
        }
    }
}