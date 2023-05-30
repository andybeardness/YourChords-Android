package com.beardness.yourchordsru.presentation.domain.usecase.songs

import com.beardness.yourchordsru.presentation.domain.core.songs.SongsCoreProtocol
import com.beardness.yourchordsru.presentation.entity.Song
import javax.inject.Inject

class SongsUseCase @Inject constructor(
    private val songsCore: SongsCoreProtocol,
) : SongsUseCaseProtocol {

    override suspend fun songs(authorId: Int): List<Song> =
        songsCore
            .songs(authorId = authorId)

}