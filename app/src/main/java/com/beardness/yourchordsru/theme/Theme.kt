package com.beardness.yourchordsru.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.beardness.yourchordsru.theme.colors.AppColors
import com.beardness.yourchordsru.theme.colors.LocalExtendedColors
import com.beardness.yourchordsru.theme.colors.darkColors
import com.beardness.yourchordsru.theme.colors.lightColors
import com.beardness.yourchordsru.theme.dimens.AppDimens
import com.beardness.yourchordsru.theme.dimens.LocalExtendedDimens
import com.beardness.yourchordsru.theme.dimens.dimens
import com.beardness.yourchordsru.theme.typography.AppTypography
import com.beardness.yourchordsru.theme.typography.LocalExtendedTypography
import com.beardness.yourchordsru.theme.typography.typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun YourChordsRuTheme(
    content: @Composable () -> Unit,
) {
    val isDarkTheme = true

    val colors =
        if (isDarkTheme) {
            darkColors
        } else {
            lightColors
        }

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(color = colors.card)

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