package com.beardness.yourchordsru.ui.widgets.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchToolbarWidget(
    input: String,
    onUpdateInput: (String) -> Unit,
    onClickSearch: (String) -> Unit,
    onClickNavigation: () -> Unit,
    isSearch: Boolean,
) {
    Column(
        modifier = Modifier
            .height(height = YourChordsRuTheme.dimens.dp128)
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
                    icon = Icons.Rounded.Sync,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text.copy(alpha = .2f),
                    onClick = { }
                )
            } else {
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
        ) {

        }
    }
}

@Composable
@Preview
fun Preview_SearchToolbarWidget_0() {
    SearchToolbarWidget(
        input = "",
        onUpdateInput = { },
        onClickSearch = { },
        onClickNavigation = { },
        isSearch = false,
    )
}