package com.beardness.yourchordsru.presentation.screens.search

import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import kotlinx.coroutines.flow.StateFlow

interface ISearchScreenViewModel {
    val input: StateFlow<String>
    val searchResult: StateFlow<List<SearchResult>>
    val isSearch: StateFlow<Boolean>
    val scrollUp: StateFlow<Boolean?>
    fun updateInput(update: String)
    fun search(pattern: String)
    fun navigateBySearchResult(searchResult: SearchResult)
    fun navigateBack()
    fun updateScrollPosition(firstVisibleItemIndex: Int)
}