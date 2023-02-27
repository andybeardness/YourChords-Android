package com.beardness.yourchordsru.ui.widgets.toolbar.chords

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget

@Composable
fun BaseChordsToolbarWidget(
    title: String,
    onClickNavigation: () -> Unit,
    isFavoriteSong: Boolean,
    onClickFavoriteSong: () -> Unit,
    isExpanded: Boolean,
    onClickExpand: () -> Unit,
) {
    val favoriteIcon =
        if (isFavoriteSong) {
            Icons.Rounded.Star
        } else {
            Icons.Rounded.StarBorder
        }

    val favoriteColor =
        if (isFavoriteSong) {
            YourChordsRuTheme.colors.yellow
        } else {
            YourChordsRuTheme.colors.text
        }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .background(color = YourChordsRuTheme.colors.card),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ToolbarIconWidget(
            icon = Icons.Rounded.ChevronLeft,
            iconDescription = "",
            iconColor = YourChordsRuTheme.colors.text,
            onClick = onClickNavigation,
        )

        Text(
            modifier = Modifier
                .weight(weight = 1f),
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.titleAtToolbar,
        )

        ToolbarIconWidget(
            icon = favoriteIcon,
            iconDescription = "",
            iconColor = favoriteColor,
            onClick = onClickFavoriteSong,
        )

        if (isExpanded) {
            ToolbarIconWidget(
                icon = Icons.Rounded.ExpandLess,
                iconDescription = "",
                iconColor = YourChordsRuTheme.colors.text,
                onClick = onClickExpand,
            )
        } else {
            ToolbarIconWidget(
                icon = Icons.Rounded.ExpandMore,
                iconDescription = "",
                iconColor = YourChordsRuTheme.colors.text,
                onClick = onClickExpand,
            )
        }
    }
}