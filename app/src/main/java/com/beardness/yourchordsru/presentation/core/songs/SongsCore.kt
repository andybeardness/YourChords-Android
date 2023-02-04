package com.beardness.yourchordsru.presentation.core.songs

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.core.dto.songsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import javax.inject.Inject

class SongsCore @Inject constructor(
    private val songsRepo: ISongsRepo,
) : ISongsCore {
    override suspend fun songs(authorId: Int): List<SongCoreDto> {
        return songsRepo
            .songs(authorId = authorId)
            .sortedWith(
                compareBy(
                    { songViewDto -> songViewDto.title },
                    { songViewDto -> -songViewDto.rating }
                )
            )
            .songsRepoDtoToCoreDto()
    }

    override suspend fun song(authorId: Int, songId: Int): SongCoreDto? {
        return songsRepo
            .song(authorId = authorId, songId = songId)
            ?.coreDto()
    }
}