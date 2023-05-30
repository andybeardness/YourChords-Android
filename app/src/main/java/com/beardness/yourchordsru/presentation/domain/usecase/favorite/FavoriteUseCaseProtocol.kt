package com.beardness.yourchordsru.presentation.domain.usecase.favorite

import com.beardness.yourchordsru.presentation.types.FavoriteType
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCaseProtocol {
    val favoriteAuthorsIds: Flow<List<Int>>

    val favoriteSongsIds: Flow<List<Int>>
    val favoriteSongsAuthorsIds: Flow<List<Int>>

    suspend fun changeAuthorFavorite(authorId: Int)
    suspend fun changeSongFavorite(authorId: Int, songId: Int)

    suspend fun authorFavoriteType(authorId: Int): FavoriteType
    suspend fun favoriteSongsIds(authorId: Int): List<Int>
}
