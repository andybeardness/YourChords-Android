package com.beardness.yourchordsru.ui.widgets.settings.colors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SettingsColorPickerWidget(
    title: String,
    colors: Set<Color>,
    activeColor: Color,
    onClickColor: (color: Color) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = YourChordsRuTheme.dimens.dp8,
                    vertical = YourChordsRuTheme.dimens.dp4,
                ),
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.titleAtSettings,
        )

        SettingsColorsLineFromPickerWidget(
            colors = colors,
            activeColor = activeColor,
            onClickColor = onClickColor,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_SettingsColorPickerWidget_0() {
    SettingsColorPickerWidget(
        title = "Title",
        colors = setOf(
            Color(color = 0xFFFF0000),
            Color(color = 0xFF00FF00),
            Color(color = 0xFF0000FF),
        ),
        activeColor = Color(color = 0xFFFF0000),
        onClickColor = {},
    )
}