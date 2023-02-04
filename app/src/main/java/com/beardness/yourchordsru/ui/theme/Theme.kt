package com.beardness.yourchordsru.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.beardness.yourchordsru.ui.theme.colors.AppColors
import com.beardness.yourchordsru.ui.theme.colors.LocalExtendedColors
import com.beardness.yourchordsru.ui.theme.colors.darkColors
import com.beardness.yourchordsru.ui.theme.colors.lightColors

@Composable
fun YourChordsRuTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors =
        if (darkTheme) {
            darkColors
        } else {
            lightColors
        }
    
    CompositionLocalProvider(
        LocalExtendedColors provides colors,
    ) {
        MaterialTheme(content = content)
    }
}

object YourChordsRuTheme {
    val colors: AppColors
        @Composable
        get() = LocalExtendedColors.current
}