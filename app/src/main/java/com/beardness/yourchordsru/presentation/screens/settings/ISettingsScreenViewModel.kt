package com.beardness.yourchordsru.presentation.screens.settings

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.screens.settings.types.ChordsColorSettingsType
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import kotlinx.coroutines.flow.StateFlow

interface ISettingsScreenViewModel {
    val activeTheme: StateFlow<ThemeSettingsType>
    val activeBackgroundColor: StateFlow<Color>
    val activeTextColor: StateFlow<Color>
    val activeChordsColor: StateFlow<ChordsColorSettingsType>
    val themesTypes: StateFlow<Set<ThemeSettingsType>>
    val backgroundColors: StateFlow<Set<Color>>
    val textColors: StateFlow<Set<Color>>
    val chordsColors: StateFlow<Set<ChordsColorSettingsType>>
    val fontSize: StateFlow<Int>
    fun updateTheme(theme: ThemeSettingsType)
    fun updateBackgroundColor(color: Color)
    fun updateTextColor(color: Color)
    fun updateChordsColor(color: Color)
    fun updateFontSize(difference: Int)
    fun navigateBack()
}
