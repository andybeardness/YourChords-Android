package com.beardness.yourchordsru.presentation.data.reader.csv.songs

import com.beardness.yourchordsru.presentation.entity.Song

interface SongsCsvReaderProtocol {
    fun read(authorId: Int): List<Song>
    fun read(authorId: Int, songId: Int): Song?
}