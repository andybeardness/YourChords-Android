package com.beardness.yourchordsru.presentation.domain.core.favorite.song

import com.beardness.yourchordsru.presentation.domain.dto.FavoriteSongDomainDto
import kotlinx.coroutines.flow.StateFlow

interface FavoriteSongCoreProtocol {
    val favoriteSongs: StateFlow<List<FavoriteSongDomainDto>>
    suspend fun setup()
    suspend fun changeSongFavorite(authorId: Int, songId: Int)
}
