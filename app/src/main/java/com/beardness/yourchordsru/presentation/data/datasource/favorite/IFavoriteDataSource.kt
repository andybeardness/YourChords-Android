package com.beardness.yourchordsru.presentation.data.datasource.favorite

import com.beardness.yourchordsru.presentation.data.datasource.dto.FavoriteAuthorSourceDto
import com.beardness.yourchordsru.presentation.data.datasource.dto.FavoriteSongSourceDto

interface IFavoriteDataSource {
    suspend fun authors(): List<FavoriteAuthorSourceDto>
    suspend fun songs(): List<FavoriteSongSourceDto>
    suspend fun insertAuthor(authorId: Int)
    suspend fun insertSong(authorId: Int, songId: Int)
    suspend fun removeAuthor(authorId: Int)
    suspend fun removeSong(authorId: Int, songId: Int)
}