package com.beardness.yourchordsru.presentation.domain.core.songs

import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.domain.dto.SongDomainDto
import com.beardness.yourchordsru.presentation.domain.dto.toDomainDto
import javax.inject.Inject

class SongsCore @Inject constructor(
    private val songsCsvReader: SongsCsvReaderProtocol
) : SongsCoreProtocol {

    override suspend fun songs(authorId: Int): List<SongDomainDto> {
        return songsCsvReader
            .read(authorId = authorId)
            .map { songDataDto -> songDataDto.toDomainDto() }
    }

    override suspend fun song(authorId: Int, songId: Int): SongDomainDto? {
        return songsCsvReader
            .read(authorId = authorId, songId = songId)
            ?.toDomainDto()
    }
}