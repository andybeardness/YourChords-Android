package com.beardness.yourchordsru.presentation.domain.usecase.favorite

import kotlinx.coroutines.flow.Flow

interface FavoriteUseCaseProtocol {
    val favoriteAuthorsIds: Flow<List<Int>>

    val favoriteSongsIds: Flow<List<Int>>
    val favoriteSongsAuthorsIds: Flow<List<Int>>

    suspend fun changeAuthorFavorite(authorId: Int)
    suspend fun changeSongFavorite(authorId: Int, songId: Int)

    suspend fun favoriteSongsIds(authorId: Int): List<Int>
}
