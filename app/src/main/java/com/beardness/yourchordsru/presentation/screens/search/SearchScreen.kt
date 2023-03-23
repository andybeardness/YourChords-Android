package com.beardness.yourchordsru.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.beardness.yourchordsru.ui.widgets.search.SearchCollection
import com.beardness.yourchordsru.ui.widgets.toolbar.search.AnimatedSearchFieldWidget

@Composable
fun SearchScreen(viewModel: ISearchScreenViewModel) {
    val input by viewModel.input.collectAsState()
    val isSearchByAuthorsSelected by viewModel.isSearchByAuthorsSelected.collectAsState()
    val isSearchBySongsSelected by viewModel.isSearchBySongsSelected.collectAsState()
    val searchResult by viewModel.searchResult.collectAsState()
    val isSearch by viewModel.isSearch.collectAsState()
    val scrollUp by viewModel.scrollUp.collectAsState()

    val lazyListState = rememberLazyListState()

    val toolbarVisibility =
        scrollUp ?: true

    val nestedScrollConnection =
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                viewModel.updateScrollPosition(firstVisibleItemIndex = lazyListState.firstVisibleItemIndex)
                return super.onPreScroll(available, source)
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AnimatedSearchFieldWidget(
            visibility = toolbarVisibility,
            input = input,
            onUpdateInput = { update -> viewModel.updateInput(update = update) },
            isSearchByAuthorsSelected = isSearchByAuthorsSelected,
            onClickSearchByAuthorsTag = { viewModel.clickOnSearchByAuthorsTag() },
            isSearchBySongsSelected = isSearchBySongsSelected,
            onClickSearchBySongsTag = { viewModel.clickOnSearchBySongsTag() },
            onClickSearch = { input -> viewModel.search(pattern = input) },
            onClickClear = { viewModel.clear() },
            onClickNavigation = { viewModel.navigateBack() },
            isSearch = isSearch,
        )

        SearchCollection(
            modifier = Modifier
                .weight(weight = 1f)
                .nestedScroll(connection = nestedScrollConnection),
            lazyListState = lazyListState,
            founded = searchResult,
            onClick = { item -> viewModel.navigateBySearchResult(searchResult = item) },
            onClickChangeFavorite = { item -> viewModel.changeFavorite(searchResult = item) },
        )
    }
}