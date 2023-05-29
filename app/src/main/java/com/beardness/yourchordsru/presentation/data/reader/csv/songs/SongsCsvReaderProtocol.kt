package com.beardness.yourchordsru.presentation.data.reader.csv.songs

import com.beardness.yourchordsru.presentation.data.dto.SongDataDto

interface SongsCsvReaderProtocol {
    fun read(authorId: Int): List<SongDataDto>
    fun read(authorId: Int, songId: Int): SongDataDto?
}