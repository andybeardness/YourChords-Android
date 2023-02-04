package com.beardness.yourchordsru.presentation.core.songs

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto

interface ISongsCore {
    suspend fun songs(authorId: Int): List<SongCoreDto>
    suspend fun song(authorId: Int, songId: Int): SongCoreDto?
}