package com.beardness.yourchordsru.ui.widgets.toolbar.classic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHapticNoRipple

@Composable
fun ToolbarWidget(
    title: String,
    navigationContent: @Composable (() -> Unit)? = null,
    icons: List<@Composable () -> Unit> = emptyList(),
    onClickToolbar: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .background(color = YourChordsRuTheme.colors.card),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        navigationContent?.invoke()

        Text(
            modifier = Modifier
                .weight(weight = 1f)
                .clickableHapticNoRipple { onClickToolbar?.invoke() },
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.titleAtToolbar,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier
                .padding(horizontal = YourChordsRuTheme.dimens.dp8)
        ) {
            icons.forEach { icon ->
                icon()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_ToolbarWidget_0() {
    ToolbarWidget(
        title = "Toolbar title"
    )
}

@Composable
@Preview(showBackground = true)
fun Preview_ToolbarWidget_1() {
    ToolbarWidget(
        title = "Toolbar title",
        navigationContent = {
            Icon(
                modifier = Modifier
                    .padding(all = YourChordsRuTheme.dimens.dp8)
                    .clip(shape = RoundedCornerShape(percent = 50))
                    .clickable { }
                    .padding(all = YourChordsRuTheme.dimens.dp8)
                    .size(size = YourChordsRuTheme.dimens.dp32),
                imageVector = Icons.Rounded.Menu,
                contentDescription = "",
                tint = YourChordsRuTheme.colors.text,
            )
        },
        icons = listOf {
            Icon(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(percent = 50))
                    .clickable { }
                    .padding(all = YourChordsRuTheme.dimens.dp8)
                    .size(size = YourChordsRuTheme.dimens.dp32),
                imageVector = Icons.Rounded.Search,
                contentDescription = "",
                tint = YourChordsRuTheme.colors.text,
            )

            Icon(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(percent = 50))
                    .clickable { }
                    .padding(all = YourChordsRuTheme.dimens.dp8)
                    .size(size = YourChordsRuTheme.dimens.dp32),
                imageVector = Icons.Rounded.Search,
                contentDescription = "",
                tint = YourChordsRuTheme.colors.text,
            )
        }
    )
}