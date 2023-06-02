package com.beardness.yourchordsru.presentation.view.screen.chords

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.awake.AwakeUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.chords.ChordsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCaseProtocol
import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import com.beardness.yourchordsru.utils.html.builder.IHtmlBuilder
import com.beardness.yourchordsru.utils.html.colors.HtmlColorUtilsProtocol
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
    private val awakeUseCase: AwakeUseCaseProtocol,
    private val htmlBuilder: IHtmlBuilder,
    private val htmlColorHelper: HtmlColorUtilsProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), ChordsScreenViewModelProtocol {

    init {
        awake(signal = true)
    }

    private val _authorId = MutableStateFlow<Int?>(value = null)
    private val _songId = MutableStateFlow<Int?>(value = null)
    private val _fontSizePx = chordsUseCase.fontSize

    override val isMaxFontSize = chordsUseCase.isMaxFontSize
    override val isMinFontSize = chordsUseCase.isMinFontSize

    override val viewMode = chordsUseCase.viewMode
        .map { viewModeCode -> ChordsViewMode.fromCode(code = viewModeCode) }

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
            viewMode,
        ) { authorId, songId, fontSizePx, viewMode ->
            authorId ?: return@combine null
            songId ?: return@combine null

            val rawChords =
                chordsUseCase
                    .chords(authorId = authorId, songId = songId)
                    ?: return@combine null

            val htmlColors = htmlColorHelper.choose(mode = viewMode)

            htmlBuilder.html(
                content = rawChords,
                backgroundColor = htmlColors.backgroundColor,
                textColor = htmlColors.textColor,
                chordsColor = htmlColors.chordsColor,
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
            chordsUseCase.increaseFontSize()
        }
    }

    override fun decreaseText() {
        ioCoroutineScope.launch {
            chordsUseCase.decreaseFontSize()
        }
    }

    override fun swapViewMode() {
        ioCoroutineScope.launch {
            chordsUseCase.swapViewMode()
        }
    }

    override fun awake(signal: Boolean) {
        ioCoroutineScope.launch {
            awakeUseCase.makeAwake(value = signal)
        }
    }

    override fun onCleared() {
        awake(signal = false)
        super.onCleared()
    }
}