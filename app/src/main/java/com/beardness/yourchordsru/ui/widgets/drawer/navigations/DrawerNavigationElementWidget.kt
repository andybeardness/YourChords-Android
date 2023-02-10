package com.beardness.yourchordsru.ui.widgets.drawer.navigations

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic

@Composable
fun DrawerNavigationElementWidget(
    icon: ImageVector,
    iconColor: Color,
    iconDescription: String,
    title: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .height(height = YourChordsRuTheme.dimens.dp64)
            .fillMaxWidth()
            .clickableHaptic { onClick() }
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .size(size = YourChordsRuTheme.dimens.dp32),
            imageVector = icon,
            contentDescription = iconDescription,
            tint = iconColor,
        )

        Text(
            modifier = Modifier
                .padding(horizontal = YourChordsRuTheme.dimens.dp8),
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.navigationAtDrawer,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_DrawerNavigationElementWidget_0() {
    DrawerNavigationElementWidget(
        icon = Icons.Rounded.Star,
        iconColor = YourChordsRuTheme.colors.yellow,
        iconDescription = "",
        title = "Title",
        onClick = {},
    )
}

@Composable
@Preview(showBackground = true)
fun Preview_DrawerNavigationElementWidget_1() {
    DrawerNavigationElementWidget(
        icon = Icons.Rounded.Star,
        iconColor = YourChordsRuTheme.colors.yellow,
        iconDescription = "",
        title = "Long long long long long long long long long title",
        onClick = {},
    )
}