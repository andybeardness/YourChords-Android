package com.beardness.yourchordsru.ui.widgets.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchToolbarWidget(
    onClickSearch: (String) -> Unit,
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
                    horizontal = YourChordsRuTheme.dimens.dp16,
                    vertical = YourChordsRuTheme.dimens.dp8,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                modifier = Modifier
                    .weight(weight = 1f),
                value = input,
                onValueChange = { update -> input = update },
            )

            ToolbarIconWidget(
                icon = Icons.Rounded.Search,
                iconDescription = "",
                iconColor = YourChordsRuTheme.colors.text,
                onClick = { onClickSearch(input) }
            )
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
        onClickSearch = { }
    )
}