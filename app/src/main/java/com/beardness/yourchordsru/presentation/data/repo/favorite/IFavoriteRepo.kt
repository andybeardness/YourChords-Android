package com.beardness.yourchordsru.presentation.data.repo.favorite

import com.beardness.yourchordsru.presentation.data.repo.dto.FavoriteAuthorRepoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.FavoriteSongRepoDto

interface IFavoriteRepo {
    suspend fun authors(): List<FavoriteAuthorRepoDto>
    suspend fun songs(): List<FavoriteSongRepoDto>
    suspend fun insertAuthor(authorId: Int)
    suspend fun insertSong(authorId: Int, songId: Int)
    suspend fun removeAuthor(authorId: Int)
    suspend fun removeSong(authorId: Int, songId: Int)
}