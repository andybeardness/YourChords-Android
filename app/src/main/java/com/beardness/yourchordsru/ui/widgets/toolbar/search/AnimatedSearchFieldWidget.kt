package com.beardness.yourchordsru.ui.widgets.toolbar.search

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable

@Composable
fun AnimatedSearchFieldWidget(
    visibility: Boolean,
    input: String,
    onUpdateInput: (String) -> Unit,
    isSearchByAuthorsSelected: Boolean,
    onClickSearchByAuthorsTag: () -> Unit,
    isSearchBySongsSelected: Boolean,
    onClickSearchBySongsTag: () -> Unit,
    onClickSearch: (String) -> Unit,
    onClickClear: () -> Unit,
    onClickNavigation: () -> Unit,
    isSearch: Boolean,
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(durationMillis = 500))
                + expandVertically(animationSpec = tween(durationMillis = 500)),
        exit = fadeOut(animationSpec = tween(durationMillis = 500))
                + shrinkVertically(animationSpec = tween(durationMillis = 500)),
    ) {
        SearchToolbarWidget(
            input = input,
            onUpdateInput = onUpdateInput,
            isSearchByAuthorsSelected = isSearchByAuthorsSelected,
            onClickSearchByAuthorsTag = onClickSearchByAuthorsTag,
            isSearchBySongsSelected = isSearchBySongsSelected,
            onClickSearchBySongsTag = onClickSearchBySongsTag,
            onClickSearch = onClickSearch,
            onClickClear = onClickClear,
            onClickNavigation = onClickNavigation,
            isSearch = isSearch
        )
    }
}