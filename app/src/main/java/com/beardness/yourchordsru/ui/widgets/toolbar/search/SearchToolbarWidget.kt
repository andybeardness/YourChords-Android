package com.beardness.yourchordsru.ui.widgets.toolbar.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.searchtag.SearchTagWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget

@Composable
fun SearchToolbarWidget(
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
    Column(
        modifier = Modifier
            .height(height = YourChordsRuTheme.dimens.dp64x2)
            .fillMaxWidth()
            .background(color = YourChordsRuTheme.colors.card),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight = 1f)
                .padding(
                    horizontal = YourChordsRuTheme.dimens.dp8,
                    vertical = YourChordsRuTheme.dimens.dp4,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ToolbarIconWidget(
                icon = Icons.Rounded.ChevronLeft,
                iconDescription = "",
                iconColor = YourChordsRuTheme.colors.text,
                onClick = onClickNavigation,
            )

            SearchFieldWidget(
                modifier = Modifier
                    .weight(weight = 1f)
                    .padding(horizontal = YourChordsRuTheme.dimens.dp8),
                input = input,
                isSearch = isSearch,
                onUpdate = onUpdateInput,
                onClickSearch = { onClickSearch(input) }
            )

            if (isSearch) {
                ToolbarIconWidget(
                    icon = Icons.Rounded.Close,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text.copy(alpha = .2f),
                    onClick = { }
                )

                ToolbarIconWidget(
                    icon = Icons.Rounded.Sync,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text.copy(alpha = .2f),
                    onClick = { }
                )
            } else {
                ToolbarIconWidget(
                    icon = Icons.Rounded.Cancel,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.red,
                    onClick = { onClickClear() }
                )

                ToolbarIconWidget(
                    icon = Icons.Rounded.Search,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text,
                    onClick = { onClickSearch(input) }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight = 1f)
                .padding(
                    horizontal = YourChordsRuTheme.dimens.dp16,
                    vertical = YourChordsRuTheme.dimens.dp8,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            SearchTagWidget(
                title = "By authors",
                color = YourChordsRuTheme.colors.purple,
                isSelected = isSearchByAuthorsSelected,
                onClick = onClickSearchByAuthorsTag,
            )
            SearchTagWidget(
                title = "By songs",
                color = YourChordsRuTheme.colors.orange,
                isSelected = isSearchBySongsSelected,
                onClick = onClickSearchBySongsTag,
            )
        }
    }
}

@Composable
@Preview
fun Preview_SearchToolbarWidget_0() {
    SearchToolbarWidget(
        input = "",
        onUpdateInput = { },
        isSearchByAuthorsSelected = true,
        onClickSearchByAuthorsTag = { },
        isSearchBySongsSelected = true,
        onClickSearchBySongsTag = { },
        onClickSearch = { },
        onClickClear = { },
        onClickNavigation = { },
        isSearch = false,
    )
}