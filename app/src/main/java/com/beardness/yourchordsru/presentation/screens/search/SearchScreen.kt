package com.beardness.yourchordsru.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.widgets.search.SearchCollection
import com.beardness.yourchordsru.ui.widgets.toolbar.SearchToolbarWidget

@Composable
fun SearchScreen(viewModel: ISearchScreenViewModel) {
    val searchResult by viewModel.searchResult.collectAsState()
    val isSearch by viewModel.isSearch.collectAsState()

    val lazyListState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        SearchToolbarWidget(
            onClickSearch = { input -> viewModel.search(pattern = input) },
            isSearch = isSearch,
        )

        SearchCollection(
            modifier = Modifier
                .weight(weight = 1f),
            lazyListState = lazyListState,
            founded = searchResult,
            onClick = { item -> viewModel.navigateBySearchResult(searchResult = item) },
        )
    }
}