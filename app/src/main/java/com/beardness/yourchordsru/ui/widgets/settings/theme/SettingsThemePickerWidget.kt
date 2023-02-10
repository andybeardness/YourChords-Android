package com.beardness.yourchordsru.ui.widgets.settings.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SettingsThemePickerWidget(
    title: String,
    themes: Set<ThemeSettingsType>,
    activeTheme: ThemeSettingsType,
    onClickTheme: (ThemeSettingsType) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            )
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

        SettingsThemesLineWidget(
            themes = themes,
            activeTheme = activeTheme,
            onClick = onClickTheme,
        )
    }
}