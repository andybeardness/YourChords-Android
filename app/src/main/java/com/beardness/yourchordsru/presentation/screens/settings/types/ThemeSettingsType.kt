package com.beardness.yourchordsru.presentation.screens.settings.types

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