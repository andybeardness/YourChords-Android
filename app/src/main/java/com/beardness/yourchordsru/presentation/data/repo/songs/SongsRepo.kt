package com.beardness.yourchordsru.presentation.data.repo.songs

import com.beardness.yourchordsru.presentation.data.datasource.songs.ISongsDataSource
import com.beardness.yourchordsru.presentation.data.repo.dto.SongRepoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.repoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.songSourceDtoToRepoDto
import javax.inject.Inject

class SongsRepo @Inject constructor(
    private val songsDataSource: ISongsDataSource,
) : ISongsRepo {
    override suspend fun songs(authorId: Int): List<SongRepoDto> {
        return songsDataSource
            .songs(authorId = authorId)
            .songSourceDtoToRepoDto()
    }

    override suspend fun song(authorId: Int, songId: Int): SongRepoDto? {
        return songsDataSource
            .song(authorId = authorId, songId = songId)
            ?.repoDto()
    }
}