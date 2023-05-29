package com.beardness.yourchordsru.presentation.domain.core.search

import com.beardness.yourchordsru.presentation.domain.core.type.SearchResultCoreType
import kotlinx.coroutines.flow.StateFlow

interface SearchCoreProtocol {
    val founded: StateFlow<List<SearchResultCoreType>>
    val isSearching: StateFlow<Boolean>

    suspend fun search(
        pattern: String,
        isAuthorsEnabled: Boolean,
        isSongsEnabled: Boolean,
    )

    suspend fun clear()
}