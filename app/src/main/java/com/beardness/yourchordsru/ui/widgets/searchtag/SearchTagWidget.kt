package com.beardness.yourchordsru.ui.widgets.searchtag

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchTagWidget(
    title: String,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor =
        if (isSelected) {
            color
        } else {
            Color.Transparent
        }

    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = shape,
            )
            .clip(shape = shape)
            .clickable { onClick() }
            .padding(
                vertical = YourChordsRuTheme.dimens.dp8,
                horizontal = YourChordsRuTheme.dimens.dp16,
            )
    ) {
        Text(
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.tagTitleAtSearchToolbar,
        )
    }
}

@Composable
@Preview
fun Preview_SearchTagWidget_0() {
    SearchTagWidget(
        title = "Tag",
        color = YourChordsRuTheme.colors.blue,
        isSelected = true,
        onClick = {},
    )
}