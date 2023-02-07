package com.beardness.yourchordsru.ui.widgets.toolbar.chords

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget

@Composable
fun ChordsToolbarWidget(
    title: String,
    onClickNavigation: () -> Unit,
    isExpanded: Boolean,
    onClickExpand: () -> Unit,
) {
    val height by animateDpAsState(
        targetValue = if (isExpanded)
            YourChordsRuTheme.dimens.dp128
        else
            YourChordsRuTheme.dimens.dp64,
        animationSpec = tween(
            durationMillis = 300,
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .background(color = YourChordsRuTheme.colors.card)
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp8,
            )
    ) {
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

        if (isExpanded) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = YourChordsRuTheme.dimens.dp64)
                    .background(color = YourChordsRuTheme.colors.card),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.red,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.orange,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.yellow,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.green,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.cyan,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.blue,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.purple,
                    onClick = { },
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Favorite,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.pink,
                    onClick = { },
                )
            }
        }
    }
}