package com.beardness.yourchordsru.presentation.core.search

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto

interface ISearchCore {
    suspend fun searchSongs(pattern: String): List<SongCoreDto>
}