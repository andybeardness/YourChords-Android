package com.beardness.yourchordsru.ui.widgets.settings.colors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun MiniColorPickerLineWidget(
    title: String,
    colors: List<Color>,
    activeColor: Color,
    onClickColor: (Color) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .background(color = YourChordsRuTheme.colors.card),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.titleAtSongScreenToolbar,
        )

        colors.forEach { color ->
            MiniColorPickerWidget(
                color = color,
                isActive = color == activeColor,
                onClick = { onClickColor(color) },
            )
        }
    }
}