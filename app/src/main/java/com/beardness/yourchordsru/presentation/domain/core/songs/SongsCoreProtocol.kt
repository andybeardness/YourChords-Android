package com.beardness.yourchordsru.presentation.domain.core.songs

import com.beardness.yourchordsru.presentation.entity.Song


interface SongsCoreProtocol {
    suspend fun songs(authorId: Int): List<Song>
    suspend fun song(authorId: Int, songId: Int): Song?
}