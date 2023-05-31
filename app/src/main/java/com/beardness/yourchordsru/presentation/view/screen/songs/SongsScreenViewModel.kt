package com.beardness.yourchordsru.presentation.view.screen.songs

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCaseProtocol
import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.entity.Song
import com.beardness.yourchordsru.presentation.types.FavoriteType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongsScreenViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCaseProtocol,
    private val songsUseCase: SongsUseCaseProtocol,
    private val favoriteUseCase: FavoriteUseCaseProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), SongsScreenViewModelProtocol {

    private val _author = MutableStateFlow<Author?>(value = null)

    override val authorId: Flow<Int> =
        _author
            .filterNotNull()
            .map { author -> author.id }

    override val authorName: Flow<String> =
        _author
            .filterNotNull()
            .map { author -> author.name }

    override val authorFavoriteType: Flow<FavoriteType> =
        combine(
            _author,
            favoriteUseCase.favoriteAuthorsIds,
            favoriteUseCase.favoriteSongsAuthorsIds,
        ) { author, favoriteAuthorsIds, favoriteSongsAuthorsIds ->
            author ?: return@combine FavoriteType.DEFAULT

            when (author.id) {
                in favoriteAuthorsIds -> FavoriteType.FAVORITE
                in favoriteSongsAuthorsIds -> FavoriteType.PARTLY
                else -> FavoriteType.DEFAULT
            }
        }

    override val songs: Flow<List<Song>> =
        _author
            .filterNotNull()
            .map { author -> songsUseCase.songs(authorId = author.id) }

    override val favoriteSongsIds: Flow<List<Int>> = favoriteUseCase.favoriteSongsIds

    override fun setup(authorId: Int) {
        ioCoroutineScope.launch {
            val author = authorsUseCase.author(authorId = authorId)
            _author.emit(value = author)
        }
    }

    override fun swapSongFavoriteType(authorId: Int, songId: Int) {
        ioCoroutineScope.launch {
            favoriteUseCase.changeSongFavorite(authorId = authorId, songId = songId)
        }
    }
}