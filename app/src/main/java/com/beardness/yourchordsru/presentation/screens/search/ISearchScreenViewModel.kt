package com.beardness.yourchordsru.presentation.screens.search

import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import kotlinx.coroutines.flow.StateFlow

interface ISearchScreenViewModel {
    val searchResult: StateFlow<List<SearchResult>>
    val isSearch: StateFlow<Boolean>
    fun search(pattern: String)
    fun navigateBySearchResult(searchResult: SearchResult)
}