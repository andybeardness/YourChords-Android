package com.beardness.yourchordsru.presentation.domain.core.songs

import com.beardness.yourchordsru.presentation.domain.dto.SongDomainDto

interface SongsCoreProtocol {
    suspend fun songs(authorId: Int): List<SongDomainDto>
    suspend fun song(authorId: Int, songId: Int): SongDomainDto?
}