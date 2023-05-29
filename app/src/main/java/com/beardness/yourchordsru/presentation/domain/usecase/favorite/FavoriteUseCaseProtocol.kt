package com.beardness.yourchordsru.presentation.domain.usecase.favorite

import com.beardness.yourchordsru.presentation.domain.dto.FavoriteAuthorDomainDto
import com.beardness.yourchordsru.presentation.domain.dto.FavoriteSongDomainDto
import kotlinx.coroutines.flow.StateFlow

interface FavoriteUseCaseProtocol {
    val favoriteAuthors: StateFlow<List<FavoriteAuthorDomainDto>>
    val favoriteSongs: StateFlow<List<FavoriteSongDomainDto>>
    suspend fun changeAuthorFavorite(authorId: Int)
    suspend fun changeSongFavorite(authorId: Int, songId: Int)
}
