package com.beardness.yourchordsru.presentation.core.search

import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import kotlinx.coroutines.flow.StateFlow

interface ISearchCore {
    val founded: StateFlow<List<SearchResult>>
    val isSearching: StateFlow<Boolean>

    suspend fun search(pattern: String)
}