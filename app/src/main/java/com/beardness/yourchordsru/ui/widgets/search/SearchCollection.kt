package com.beardness.yourchordsru.ui.widgets.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong

@Composable
fun SearchCollection(
    modifier: Modifier,
    lazyListState: LazyListState,
    founded: List<SearchResult>,
    onClick: (item: SearchResult) -> Unit,
    onClickChangeFavorite: (item: SearchResult) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        items(count = founded.size) { index ->
            when (val item = founded[index]) {
                is SearchResultAuthor -> SearchAuthorWidget(
                    item = item,
                    onClick = { onClick(item) },
                    onClickChangeFavorite = { onClickChangeFavorite(item) }
                )
                is SearchResultSong -> SearchSongWidget(
                    item = item,
                    onClick = { onClick(item) },
                )
                else -> throw java.lang.IllegalStateException("Type of $item is not correct")
            }
        }
    }
}