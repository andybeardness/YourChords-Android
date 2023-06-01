package com.beardness.yourchordsru.theme.app.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val transparent: Color,
    val white: Color,
    val black: Color,
    val blue: Color,
    val green: Color,
    val cyan: Color,
    val purple: Color,
    val coral: Color,
    val red: Color,
    val orange: Color,
    val yellow: Color,
    val sepia: Color,
)

val LocalExtendedColors = staticCompositionLocalOf {
    AppColors(
        transparent = Color.Unspecified,
        white = Color.Unspecified,
        black = Color.Unspecified,
        blue = Color.Unspecified,
        green = Color.Unspecified,
        cyan = Color.Unspecified,
        purple = Color.Unspecified,
        coral = Color.Unspecified,
        red = Color.Unspecified,
        orange = Color.Unspecified,
        yellow = Color.Unspecified,
        sepia = Color.Unspecified,
    )
}

val appColors = AppColors(
    transparent = Color(color = 0x00000000),
    white = Color(color = 0xFFFFFFFF),
    black = Color(color = 0xFF000000),
    blue = Color(color = 0xFF007AFF),
    green = Color(color = 0xFF34C759),
    cyan = Color(color = 0xFF5AC8FA),
    purple = Color(color = 0xFFAF52DE),
    coral = Color(color = 0xFFFF2D55),
    red = Color(color = 0xFFFF3030),
    orange = Color(color = 0xFFFF9500),
    yellow = Color(color = 0xFFFFCC00),
    sepia = Color(color = 0xFFF5DEB3)
)