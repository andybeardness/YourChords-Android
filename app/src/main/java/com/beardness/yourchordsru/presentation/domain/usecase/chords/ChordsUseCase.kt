package com.beardness.yourchordsru.presentation.domain.usecase.chords

import com.beardness.yourchordsru.presentation.domain.core.songs.SongsCoreProtocol
import javax.inject.Inject

class ChordsUseCase @Inject constructor(
    private val songsCore: SongsCoreProtocol,
) : ChordsUseCaseProtocol {

    override suspend fun chords(authorId: Int, songId: Int): String? =
        songsCore
            .song(authorId = authorId, songId = songId)
            ?.chords

}