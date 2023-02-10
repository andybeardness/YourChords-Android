package com.beardness.yourchordsru.presentation.screens.settings

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.screens.settings.types.ChordsColorSettingsType
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import com.beardness.yourchordsru.presentation.screens.settings.types.toChordsColorSettingType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), ISettingsScreenViewModel {

    companion object {
        private val themesSet: Set<ThemeSettingsType> =
            ThemeSettingsType
                .values()
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

    private val _activeBackgroundColor = MutableStateFlow<Color>(value = Color(color = 0xFFFAFAFA))
    override val activeBackgroundColor = _activeBackgroundColor.asStateFlow()

    private val _activeTextColor = MutableStateFlow<Color>(value = Color(color = 0xFF000000))
    override val activeTextColor = _activeTextColor.asStateFlow()

    private val _activeChordsColor = MutableStateFlow<ChordsColorSettingsType>(value = ChordsColorSettingsType.CYAN)
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

    override fun updateTheme(theme: ThemeSettingsType) {
        ioCoroutineScope.launch {
            if (theme != _activeTheme.value) {
                _activeTheme.emit(value = theme)
            }
        }
    }

    override fun updateBackgroundColor(color: Color) {
        ioCoroutineScope.launch {
            _activeBackgroundColor.emit(value = color)
        }
    }

    override fun updateTextColor(color: Color) {
        ioCoroutineScope.launch {
            _activeTextColor.emit(value = color)
        }
    }

    override fun updateChordsColor(color: Color) {
        ioCoroutineScope.launch {
            val colorType = color.toChordsColorSettingType()
            _activeChordsColor.emit(value = colorType)
        }
    }

    override fun updateFontSize(difference: Int) {
        ioCoroutineScope.launch {
            val newValue =
                _fontSize.value + difference

            _fontSize.emit(value = newValue)
        }
    }

    override fun navigateBack() {
        navigator.back()
    }
}