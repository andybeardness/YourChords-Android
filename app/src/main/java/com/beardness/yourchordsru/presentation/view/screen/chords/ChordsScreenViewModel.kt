package com.beardness.yourchordsru.presentation.view.screen.chords

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.chords.ChordsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCaseProtocol
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
        ) { authorId, songId ->
            authorId ?: return@combine null
            songId ?: return@combine null

            val rawChords =
                chordsUseCase
                    .chords(authorId = authorId, songId = songId)
                    ?: return@combine null

            htmlBuilder.html(
                content = rawChords,
                backgroundColor = Color.White,
                textColor = Color.Black,
                chordsColor = Color.Black,
                textSizePx = 16,
            )
        }.filterNotNull()

    override fun setup(authorId: Int, songId: Int) {
        ioCoroutineScope.launch {
            _authorId.emit(value = authorId)
            _songId.emit(value = songId)
        }
    }
}