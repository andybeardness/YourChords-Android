package com.beardness.yourchordsru.presentation.screens.settings

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.screens.settings.types.ChordsColorSettingsType
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import com.beardness.yourchordsru.presentation.screens.settings.types.themeSettingsType
import com.beardness.yourchordsru.presentation.screens.settings.types.toChordsColorSettingType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val settingsCore: ISettingsCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), ISettingsScreenViewModel {

    companion object {
        private val themesSet: Set<ThemeSettingsType> =
            ThemeSettingsType
                .values()
                .filter { type -> type != ThemeSettingsType.NONE }
                .toSet()

        private val backgroundColorsSet = setOf<Color>(
            Color(color = 0xFFFAFAFA),
            Color(color = 0xFFF5F5F5),
            Color(color = 0xFF121212),
            Color(color = 0xFF272727),
        )

        private val textColorsSet = setOf<Color>(
            Color(color = 0xFF000000),
            Color(color = 0xFFFFFFFF),
        )

        private val chordsColorsSet: Set<ChordsColorSettingsType> =
            ChordsColorSettingsType
                .values()
                .toSet()
    }

    private val _activeTheme = MutableStateFlow<ThemeSettingsType>(value = ThemeSettingsType.DEVICE)
    override val activeTheme = _activeTheme.asStateFlow()

    private val _activeBackgroundColor = MutableStateFlow<Color>(value = Color.Unspecified)
    override val activeBackgroundColor = _activeBackgroundColor.asStateFlow()

    private val _activeTextColor = MutableStateFlow<Color>(value = Color.Unspecified)
    override val activeTextColor = _activeTextColor.asStateFlow()

    private val _activeChordsColor = MutableStateFlow<ChordsColorSettingsType>(value = ChordsColorSettingsType.BLUE)
    override val activeChordsColor = _activeChordsColor.asStateFlow()

    private val _themesTypes = MutableStateFlow<Set<ThemeSettingsType>>(value = themesSet)
    override val themesTypes = _themesTypes.asStateFlow()

    private val _backgroundColors = MutableStateFlow<Set<Color>>(value = backgroundColorsSet)
    override val backgroundColors = _backgroundColors.asStateFlow()

    private val _textColors = MutableStateFlow<Set<Color>>(value = textColorsSet)
    override val textColors = _textColors.asStateFlow()

    private val _chordsColors = MutableStateFlow<Set<ChordsColorSettingsType>>(value = chordsColorsSet)
    override val chordsColors = _chordsColors.asStateFlow()

    private val _fontSize = MutableStateFlow<Int>(value = 16)
    override val fontSize = _fontSize.asStateFlow()

    init {
        collectChordsView()
        collectTheme()
    }

    override fun updateTheme(theme: ThemeSettingsType) {
        ioCoroutineScope.launch {
            if (theme != _activeTheme.value) {
                _activeTheme.emit(value = theme)
                settingsCore.setupThemeCode(code = theme.id)
            }
        }
    }

    override fun updateBackgroundColor(color: Color) {
        ioCoroutineScope.launch {
            if (color != _activeBackgroundColor.value) {
                settingsCore.setupBackgroundColor(color = color)
            }
        }
    }

    override fun updateTextColor(color: Color) {
        ioCoroutineScope.launch {
            if (color != _activeTextColor.value) {
                settingsCore.setupTextColor(color = color)
            }
        }
    }

    override fun updateChordsColor(color: Color) {
        ioCoroutineScope.launch {
            if (color.toChordsColorSettingType() != _activeChordsColor.value) {
                settingsCore.setupChordsColor(color = color)
            }
        }
    }

    override fun updateFontSize(difference: Int) {
        ioCoroutineScope.launch {
            val newValue =
                _fontSize.value + difference

            settingsCore.setupFontSize(size = newValue)
        }
    }

    override fun navigateBack() {
        updateTheme(theme = _activeTheme.value)
        navigator.back()
    }

    private fun collectChordsView() {
        ioCoroutineScope.launch {
            settingsCore.chordsView.collect { chordsViewDto ->
                _activeBackgroundColor.emit(value = chordsViewDto.backgroundColor)
                _activeTextColor.emit(value = chordsViewDto.textColor)
                _activeChordsColor.emit(value = chordsViewDto.chordsColor.toChordsColorSettingType())
                _fontSize.emit(value = chordsViewDto.fontSize)
            }
        }
    }

    private fun collectTheme() {
        ioCoroutineScope.launch {
            settingsCore.themeCode.collect { code ->
                _activeTheme.emit(value = code.themeSettingsType())
            }
        }
    }
}