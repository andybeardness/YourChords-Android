package com.beardness.yourchordsru.presentation.screens.search

import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import kotlinx.coroutines.flow.StateFlow

interface ISearchScreenViewModel {
    val input: StateFlow<String>
    val isSearchByAuthorsSelected: StateFlow<Boolean>
    val isSearchBySongsSelected: StateFlow<Boolean>
    val searchResult: StateFlow<List<SearchResult>>
    val isSearch: StateFlow<Boolean>
    val scrollUp: StateFlow<Boolean?>
    fun updateInput(update: String)
    fun clickOnSearchByAuthorsTag()
    fun clickOnSearchBySongsTag()
    fun search(pattern: String)
    fun clear()
    fun navigateBySearchResult(searchResult: SearchResult)
    fun navigateBack()
    fun updateScrollPosition(firstVisibleItemIndex: Int)
    fun makeFavorite(searchResult: SearchResult)
    fun removeFavorite(searchResult: SearchResult)
}