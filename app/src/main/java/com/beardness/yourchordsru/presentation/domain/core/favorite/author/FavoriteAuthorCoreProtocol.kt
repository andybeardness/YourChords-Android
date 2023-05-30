package com.beardness.yourchordsru.presentation.domain.core.favorite.author

import kotlinx.coroutines.flow.Flow

interface FavoriteAuthorCoreProtocol {
    val favoriteAuthorsIds: Flow<List<Int>>
    suspend fun setup()
    suspend fun changeAuthorFavorite(authorId: Int)
    suspend fun doesAuthorInFavorite(authorId: Int): Boolean
}
