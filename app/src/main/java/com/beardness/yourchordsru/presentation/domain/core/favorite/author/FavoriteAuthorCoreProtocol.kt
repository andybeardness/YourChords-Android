package com.beardness.yourchordsru.presentation.domain.core.favorite.author

import com.beardness.yourchordsru.presentation.domain.dto.FavoriteAuthorDomainDto
import kotlinx.coroutines.flow.StateFlow

interface FavoriteAuthorCoreProtocol {
    val favoriteAuthors: StateFlow<List<FavoriteAuthorDomainDto>>
    suspend fun setup()
    suspend fun changeAuthorFavorite(authorId: Int)
}
