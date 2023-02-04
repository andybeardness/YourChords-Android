package com.beardness.yourchordsru.presentation.data.datasource.songs

import com.beardness.yourchordsru.presentation.data.datasource.dto.SongSourceDto

interface ISongsDataSource {
    fun songs(authorId: Int): List<SongSourceDto>
    fun song(authorId: Int, songId: Int): SongSourceDto?
}