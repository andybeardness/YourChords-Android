package com.beardness.yourchordsru.utils.csvreader.songs

import com.beardness.yourchordsru.presentation.data.datasource.dto.SongSourceDto

interface ISongsCsvReader {
    fun read(authorId: Int): List<SongSourceDto>
    fun read(authorId: Int, songId: Int): SongSourceDto?
}