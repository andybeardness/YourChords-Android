package com.beardness.yourchordsru.presentation.screens.search

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.search.ISearchCore
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val navigator: INavigator,
    private val searchCore: ISearchCore,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), ISearchScreenViewModel {

    override val searchResult = searchCore.founded
    override val isSearch = searchCore.isSearching

    override fun search(pattern: String) {
        ioCoroutineScope.launch {
            val prettyPattern =
                pattern
                    .trim()
                    .lowercase()

            searchCore.search(pattern = prettyPattern)
        }
    }

    override fun navigateBySearchResult(searchResult: SearchResult) {
        when (searchResult) {
            is SearchResultAuthor -> navigator.author(
                authorId = searchResult.authorId,
            )
            is SearchResultSong -> navigator.song(
                authorId = searchResult.authorId,
                songId = searchResult.authorId,
            )
        }
    }
}