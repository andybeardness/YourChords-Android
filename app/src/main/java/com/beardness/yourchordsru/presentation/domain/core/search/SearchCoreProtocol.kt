package com.beardness.yourchordsru.presentation.domain.core.search

import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.entity.Song
import kotlinx.coroutines.flow.StateFlow

interface SearchCoreProtocol {
    val foundedAuthors: StateFlow<List<Author>>
    val foundedSongs: StateFlow<List<Song>>

    val isSearching: StateFlow<Boolean>

    suspend fun search(
        pattern: String,
        isAuthorsEnabled: Boolean,
        isSongsEnabled: Boolean,
    )

    suspend fun clear()
}