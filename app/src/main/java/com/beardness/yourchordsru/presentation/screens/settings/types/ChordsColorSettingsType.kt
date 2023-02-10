package com.beardness.yourchordsru.presentation.screens.settings.types

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

enum class ChordsColorSettingsType {
    RED,
    YELLOW,
    GREEN,
    CYAN,
}

fun Color.toChordsColorSettingType(): ChordsColorSettingsType =
    when(this) {
        Color(0xFFFF3B30),
        Color(0xFFFF453A) -> ChordsColorSettingsType.RED

        Color(0xFFFFCC00),
        Color(0xFFFFCC00) -> ChordsColorSettingsType.YELLOW

        Color(0xFF34C759),
        Color(0xFF34C759) -> ChordsColorSettingsType.GREEN

        Color(0xFF5AC8FA),
        Color(0xFF5AC8FA) -> ChordsColorSettingsType.CYAN

        else -> ChordsColorSettingsType.CYAN
    }

@Composable
fun ChordsColorSettingsType.color(): Color =
    when (this) {
        ChordsColorSettingsType.RED -> YourChordsRuTheme.colors.red
        ChordsColorSettingsType.YELLOW -> YourChordsRuTheme.colors.yellow
        ChordsColorSettingsType.GREEN -> YourChordsRuTheme.colors.green
        ChordsColorSettingsType.CYAN -> YourChordsRuTheme.colors.cyan
    }

@Composable
fun Collection<ChordsColorSettingsType>.chordsColorSettingsTypeToColors(): Collection<Color> =
    this.map { chordsColorSettingsType -> chordsColorSettingsType.color() }