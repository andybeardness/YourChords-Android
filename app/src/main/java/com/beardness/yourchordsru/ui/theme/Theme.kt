package com.beardness.yourchordsru.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import com.beardness.yourchordsru.ui.theme.colors.AppColors
import com.beardness.yourchordsru.ui.theme.colors.LocalExtendedColors
import com.beardness.yourchordsru.ui.theme.colors.darkColors
import com.beardness.yourchordsru.ui.theme.colors.lightColors
import com.beardness.yourchordsru.ui.theme.dimens.AppDimens
import com.beardness.yourchordsru.ui.theme.dimens.LocalExtendedDimens
import com.beardness.yourchordsru.ui.theme.dimens.dimens
import com.beardness.yourchordsru.ui.theme.typography.AppTypography
import com.beardness.yourchordsru.ui.theme.typography.LocalExtendedTypography
import com.beardness.yourchordsru.ui.theme.typography.typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun YourChordsRuTheme(
    theme: ThemeSettingsType,
    content: @Composable () -> Unit,
) {
    val isDarkTheme =
        when (theme) {
            ThemeSettingsType.LIGHT -> false
            ThemeSettingsType.DARK -> true
            ThemeSettingsType.DEVICE -> isSystemInDarkTheme()
            ThemeSettingsType.NONE -> false
        }

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