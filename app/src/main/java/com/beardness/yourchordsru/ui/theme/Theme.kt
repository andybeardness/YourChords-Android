package com.beardness.yourchordsru.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.beardness.yourchordsru.ui.theme.colors.AppColors
import com.beardness.yourchordsru.ui.theme.colors.LocalExtendedColors
import com.beardness.yourchordsru.ui.theme.colors.darkColors
import com.beardness.yourchordsru.ui.theme.colors.lightColors
import com.beardness.yourchordsru.ui.theme.dimens.AppDimens
import com.beardness.yourchordsru.ui.theme.dimens.LocalExtendedDimens
import com.beardness.yourchordsru.ui.theme.dimens.dimens
import com.beardness.yourchordsru.ui.theme.typography.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun YourChordsRuTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    val statusBarColor =
        if (darkTheme) {
            darkColors.background
        } else {
            lightColors.background
        }

    systemUiController.setSystemBarsColor(color = statusBarColor)

    val colors =
        if (darkTheme) {
            darkColors
        } else {
            lightColors
        }

    CompositionLocalProvider(
        LocalExtendedColors provides colors,
        LocalExtendedDimens provides dimens,
        LocalExtendedTypography provides typography,
    ) {
        MaterialTheme(content = content)
    }
}

object YourChordsRuTheme {
    val colors: AppColors
        @Composable
        get() = LocalExtendedColors.current

    val dimens: AppDimens
        @Composable
        get() = LocalExtendedDimens.current

    val typography: AppTypography
        @Composable
        get() = LocalExtendedTypography.current
}