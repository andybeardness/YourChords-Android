package com.beardness.yourchordsru.ui.widgets.settings.theme

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SettingsThemesLineWidget(
    themes: Set<ThemeSettingsType>,
    activeTheme: ThemeSettingsType,
    onClick: (ThemeSettingsType) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64x2)
            .padding(
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        themes.forEach { theme ->
            SettingsThemeButtonWidget(
                title = theme.name,
                isActive = theme == activeTheme,
                onClick = { onClick(theme) }
            )
        }
    }
}