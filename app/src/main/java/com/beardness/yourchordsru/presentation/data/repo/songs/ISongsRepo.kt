package com.beardness.yourchordsru.presentation.data.repo.songs

import com.beardness.yourchordsru.presentation.data.repo.dto.SongRepoDto

interface ISongsRepo {
    suspend fun songs(authorId: Int): List<SongRepoDto>
    suspend fun song(authorId: Int, songId: Int): SongRepoDto?
}