package com.beardness.yourchordsru.ui.widgets.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchToolbarWidget(
    onClickSearch: (String) -> Unit,
    isSearch: Boolean,
) {
    var input by remember { mutableStateOf(value = "") }

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
            SearchFieldWidget(
                modifier = Modifier
                    .weight(weight = 1f),
                input = input,
                isSearch = isSearch,
                onUpdate = { update -> input = update },
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
        onClickSearch = { },
        isSearch = false,
    )
}