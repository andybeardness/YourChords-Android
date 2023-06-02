package com.beardness.yourchordsru.presentation.domain.core.songs

import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.entity.Song
import javax.inject.Inject

class SongsCore @Inject constructor(
    private val songsCsvReader: SongsCsvReaderProtocol,
) : SongsCoreProtocol {

    override suspend fun songs(authorId: Int): List<Song> {
        return songsCsvReader
            .read(authorId = authorId)
    }

    override suspend fun song(authorId: Int, songId: Int): Song? {
        return songsCsvReader
            .read(authorId = authorId, songId = songId)
    }
}