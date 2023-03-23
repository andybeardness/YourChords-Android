package com.beardness.yourchordsru.presentation.core.favorite

import com.beardness.yourchordsru.presentation.core.dto.FavoriteAuthorCoreDto
import com.beardness.yourchordsru.presentation.core.dto.FavoriteSongCoreDto
import kotlinx.coroutines.flow.StateFlow

interface IFavoriteCore {
    val favoriteAuthors: StateFlow<List<FavoriteAuthorCoreDto>>
    val favoriteSongs: StateFlow<List<FavoriteSongCoreDto>>
    suspend fun load()
    suspend fun changeAuthorFavorite(authorId: Int)
    suspend fun changeSongFavorite(authorId: Int, songId: Int)
}