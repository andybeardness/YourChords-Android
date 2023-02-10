package com.beardness.yourchordsru.ui.widgets.settings.colors

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SettingsColorsLineFromPickerWidget(
    colors: Set<Color>,
    activeColor: Color,
    onClickColor: (color: Color) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64x2)
            .padding(
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        colors.forEach { color ->
            SettingsColorFromPickerWidget(
                color = color,
                isActive = color == activeColor,
                onClick = { onClickColor(color) }
            )
        }
    }
}

@Composable
@Preview
fun Preview_SettingsColorsLineFromPickerWidget_0() {
    SettingsColorsLineFromPickerWidget(
        colors = setOf(
            Color(color = 0xFFFF0000),
            Color(color = 0xFF00FF00),
            Color(color = 0xFF0000FF),
        ),
        activeColor = Color(color = 0xFFFF0000),
        onClickColor = { },
    )
}