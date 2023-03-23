package com.beardness.yourchordsru.presentation.core.favorite

import com.beardness.yourchordsru.presentation.core.dto.FavoriteAuthorCoreDto
import com.beardness.yourchordsru.presentation.core.dto.FavoriteSongCoreDto
import com.beardness.yourchordsru.presentation.core.dto.favoriteAuthorRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.core.dto.favoriteSongRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.data.repo.favorite.IFavoriteRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FavoriteCore @Inject constructor(
    private val favoriteRepo: IFavoriteRepo,
) : IFavoriteCore {

    private val _favoriteAuthors = MutableStateFlow<List<FavoriteAuthorCoreDto>>(value = emptyList())
    override val favoriteAuthors = _favoriteAuthors.asStateFlow()

    private val _favoriteSongs = MutableStateFlow<List<FavoriteSongCoreDto>>(value = emptyList())
    override val favoriteSongs = _favoriteSongs.asStateFlow()

    override suspend fun load() {
        reloadFavoriteAuthors()
        reloadFavoriteSongs()
    }

    override suspend fun changeAuthorFavorite(authorId: Int) {
        val isFavorite =
            _favoriteAuthors
                .value
                .map { author -> author.authorId }
                .contains(element = authorId)

        if (isFavorite) {
            favoriteRepo.removeAuthor(authorId = authorId)
        } else {
            favoriteRepo.insertAuthor(authorId = authorId)
        }

        reloadFavoriteAuthors()
    }

    override suspend fun changeSongFavorite(authorId: Int, songId: Int) {
        val isFavorite =
            _favoriteSongs
                .value
                .map { song -> song.songId }
                .contains(element = songId)

        if (isFavorite) {
            favoriteRepo.removeSong(authorId = authorId, songId = songId)
        } else {
            favoriteRepo.insertSong(authorId = authorId, songId = songId)
        }

        reloadFavoriteSongs()
    }

    private suspend fun reloadFavoriteAuthors() {
        val favoriteAuthorsFromDb =
            favoriteRepo
                .authors()
                .favoriteAuthorRepoDtoToCoreDto()

        _favoriteAuthors.emit(value = favoriteAuthorsFromDb)
    }

    private suspend fun reloadFavoriteSongs() {
        val favoriteSongsFromDb =
            favoriteRepo
                .songs()
                .favoriteSongRepoDtoToCoreDto()

        _favoriteSongs.emit(value = favoriteSongsFromDb)
    }
}