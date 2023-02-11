package com.beardness.yourchordsru.presentation.screens.settings.types

import androidx.compose.runtime.Composable

enum class ThemeSettingsType(val id: Int) {
    NONE(id = -1),
    DEVICE(id = 0),
    LIGHT(id = 1),
    DARK(id = 2),
}

fun Int.themeSettingsType(): ThemeSettingsType =
    when (this) {
        0 -> ThemeSettingsType.DEVICE
        1 -> ThemeSettingsType.LIGHT
        2 -> ThemeSettingsType.DARK
        else -> ThemeSettingsType.NONE
    }

@Composable
fun ThemeSettingsType.title(): String =
    when (this) {
        ThemeSettingsType.NONE -> "None"
        ThemeSettingsType.DEVICE -> "Like device"
        ThemeSettingsType.LIGHT -> "Light"
        ThemeSettingsType.DARK -> "Dark"
    }