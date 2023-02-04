package com.beardness.yourchordsru.ui.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val background: Color,
    val card: Color,
    val text: Color,
    val red: Color,
    val orange: Color,
    val yellow: Color,
    val green: Color,
    val cyan: Color,
    val blue: Color,
    val purple: Color,
    val pink: Color,
)

val lightColors = AppColors(
    background = Color(0xFFFAFAFA),
    card = Color(0xFFF5F5F5),
    text = Color(0xFF000000),
    red = Color(0xFFFF3B30),
    orange = Color(0xFFFF9500),
    yellow = Color(0xFFFFCC00),
    green = Color(0xFF34C759),
    cyan = Color(0xFF5AC8FA),
    blue = Color(0xFF007AFF),
    purple = Color(0xFF5856D6),
    pink = Color(0xFFAF52DE),
)

val darkColors = AppColors(
    background = Color(0xFF121212),
    card = Color(0xFF272727),
    text = Color(0xFFFFFFFF),
    red = Color(0xFFFF453A),
    orange = Color(0xFFFF9500),
    yellow = Color(0xFFFFCC00),
    green = Color(0xFF34C759),
    cyan = Color(0xFF5AC8FA),
    blue = Color(0xFF0A84FF),
    purple = Color(0xFF5856D6),
    pink = Color(0xFFAF52DE),
)

val LocalExtendedColors = staticCompositionLocalOf {
    AppColors(
        background = lightColors.background,
        card = lightColors.card,
        text = lightColors.text,
        red = lightColors.red,
        orange = lightColors.orange,
        yellow = lightColors.yellow,
        green = lightColors.green,
        cyan = lightColors.cyan,
        blue = lightColors.blue,
        purple = lightColors.purple,
        pink = lightColors.pink,
    )
}
