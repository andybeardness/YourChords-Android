package com.beardness.yourchordsru.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.beardness.yourchordsru.theme.app.colors.AppColors
import com.beardness.yourchordsru.theme.app.colors.LocalExtendedColors
import com.beardness.yourchordsru.theme.app.colors.appColors
import com.beardness.yourchordsru.theme.app.dimens.AppDimens
import com.beardness.yourchordsru.theme.app.dimens.LocalExtendedDimens
import com.beardness.yourchordsru.theme.app.dimens.appDimens
import com.beardness.yourchordsru.theme.m3.colors.DarkColorScheme
import com.beardness.yourchordsru.theme.m3.colors.LightColorScheme
import com.beardness.yourchordsru.theme.m3.typography.Typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    val colorScheme = when {
        dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = colorScheme.background)

    val typography = Typography

    CompositionLocalProvider(
        LocalExtendedColors provides appColors,
        LocalExtendedDimens provides appDimens,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalExtendedColors.current

    val dimens: AppDimens
        @Composable
        get() = LocalExtendedDimens.current
}