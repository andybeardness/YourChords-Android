package com.beardness.yourchordsru.presentation.data.datasource.songs

import com.beardness.yourchordsru.presentation.data.datasource.dto.SongSourceDto
import com.beardness.yourchordsru.utils.csvreader.songs.ISongsCsvReader
import javax.inject.Inject

class SongsDataSource @Inject constructor(
    private val songsCsvReader: ISongsCsvReader,
): ISongsDataSource {
    override fun songs(authorId: Int): List<SongSourceDto> {
        return songsCsvReader.read(authorId = authorId)
    }

    override fun song(authorId: Int, songId: Int): SongSourceDto? {
        return songsCsvReader.read(authorId = authorId, songId = songId)
    }
}