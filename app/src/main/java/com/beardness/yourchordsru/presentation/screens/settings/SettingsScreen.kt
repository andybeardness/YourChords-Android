package com.beardness.yourchordsru.presentation.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.screens.settings.types.chordsColorSettingsTypeToColors
import com.beardness.yourchordsru.presentation.screens.settings.types.color
import com.beardness.yourchordsru.presentation.screens.song.SongScreenViewModel
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.navigation.ArrowBackWidget
import com.beardness.yourchordsru.ui.widgets.settings.colors.SettingsColorPickerWidget
import com.beardness.yourchordsru.ui.widgets.settings.theme.SettingsThemePickerWidget
import com.beardness.yourchordsru.ui.widgets.settings.values.SettingsValuePickerWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarWidget

@Composable
fun SettingsScreen(
    viewModel: ISettingsScreenViewModel,
) {
    val themes by viewModel.themesTypes.collectAsState()
    val activeTheme by viewModel.activeTheme.collectAsState()

    val backgroundColors by viewModel.backgroundColors.collectAsState()
    val activeBackgroundColor by viewModel.activeBackgroundColor.collectAsState()

    val textColors by viewModel.textColors.collectAsState()
    val activeTextColor by viewModel.activeTextColor.collectAsState()

    val chordsColors by viewModel.chordsColors.collectAsState()
    val activeChordsColorType by viewModel.activeChordsColor.collectAsState()

    val chordsColorsSet = chordsColors.chordsColorSettingsTypeToColors().toSet()
    val activeChordsColor = activeChordsColorType.color()

    val fontSize by viewModel.fontSize.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = YourChordsRuTheme.colors.background)
    ) {
        ToolbarWidget(
            title = "Settings",
            navigationContent = {
                ArrowBackWidget(
                    onClick = { viewModel.navigateBack() }
                )
            }
        )

        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
        ) {
            SettingsThemePickerWidget(
                title = "Theme",
                themes = themes,
                activeTheme = activeTheme,
                onClickTheme = { themeSettingsType ->  viewModel.updateTheme(themeSettingsType) },
            )

            SettingsColorPickerWidget(
                title = "Background color",
                colors = backgroundColors,
                activeColor = activeBackgroundColor,
                onClickColor = { color: Color ->  viewModel.updateBackgroundColor(color = color) },
            )

            SettingsColorPickerWidget(
                title = "Text color",
                colors = textColors,
                activeColor = activeTextColor,
                onClickColor = { color: Color -> viewModel.updateTextColor(color = color) },
            )

            SettingsColorPickerWidget(
                title = "Chords color",
                colors = chordsColorsSet,
                activeColor = activeChordsColor,
                onClickColor = { color: Color -> viewModel.updateChordsColor(color = color) },
            )

            SettingsValuePickerWidget(
                title = "Font size",
                value = fontSize,
                minimum = SongScreenViewModel.MIN_FONT_SIZE_PX,
                maximum = SongScreenViewModel.MAX_FONT_SIZE_PX,
                onClickIncrease = { viewModel.updateFontSize(difference = 2) },
                onClickDecrease = { viewModel.updateFontSize(difference = -2) }
            )
        }
    }
}