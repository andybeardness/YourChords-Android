package com.beardness.yourchordsru.presentation.domain.core.favorite.song

import kotlinx.coroutines.flow.Flow

interface FavoriteSongCoreProtocol {
    val favoriteSongsAuthorsIds: Flow<List<Int>>
    val favoriteSongsIds: Flow<List<Int>>

    suspend fun changeSongFavorite(authorId: Int, songId: Int)
    suspend fun doesSongInFavorite(authorId: Int, songId: Int): Boolean
    suspend fun doesAuthorHasSongsInFavorite(authorId: Int): Boolean
    suspend fun favoriteSongsIds(authorId: Int): List<Int>
}
