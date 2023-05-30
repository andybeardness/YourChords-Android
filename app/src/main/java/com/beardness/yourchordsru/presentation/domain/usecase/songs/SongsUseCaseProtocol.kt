package com.beardness.yourchordsru.presentation.domain.usecase.songs

import com.beardness.yourchordsru.presentation.entity.Song

interface SongsUseCaseProtocol {
    suspend fun songs(authorId: Int): List<Song>
}
