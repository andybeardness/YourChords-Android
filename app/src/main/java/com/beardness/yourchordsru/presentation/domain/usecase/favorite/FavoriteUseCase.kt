package com.beardness.yourchordsru.presentation.domain.usecase.favorite

import com.beardness.yourchordsru.presentation.domain.core.favorite.author.FavoriteAuthorCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.favorite.song.FavoriteSongCoreProtocol
import com.beardness.yourchordsru.presentation.types.FavoriteType
import javax.inject.Inject

class FavoriteUseCase @Inject constructor(
    private val favoriteAuthorCore: FavoriteAuthorCoreProtocol,
    private val favoriteSongCore: FavoriteSongCoreProtocol,
) : FavoriteUseCaseProtocol {

    override val favoriteAuthorsIds = favoriteAuthorCore.favoriteAuthorsIds

    override val favoriteSongsIds = favoriteSongCore.favoriteSongsIds
    override val favoriteSongsAuthorsIds = favoriteSongCore.favoriteSongsIds

    override suspend fun changeAuthorFavorite(authorId: Int) {
        favoriteAuthorCore.changeAuthorFavorite(authorId = authorId)
    }

    override suspend fun changeSongFavorite(authorId: Int, songId: Int) {
        favoriteSongCore.changeSongFavorite(authorId = authorId, songId = songId)
    }

    override suspend fun authorFavoriteType(authorId: Int): FavoriteType {
        return when {
            favoriteAuthorCore.doesAuthorInFavorite(authorId = authorId) -> {
                FavoriteType.FAVORITE
            }
            favoriteSongCore.doesAuthorHasSongsInFavorite(authorId = authorId) -> {
                FavoriteType.PARTLY
            }
            else -> {
                FavoriteType.DEFAULT
            }
        }
    }

    override suspend fun favoriteSongsIds(authorId: Int): List<Int> {
        return favoriteSongCore.favoriteSongsIds(authorId = authorId)
    }
}