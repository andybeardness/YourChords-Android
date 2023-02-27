package com.beardness.yourchordsru.utils.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

private const val ABC_CHARS = "abcdefghijklmnopqrstuvwxyz"

@Composable
fun Char.toAuthorFirstCharColor(): Color {
    return when {
        this.isDigit() -> YourChordsRuTheme.colors.blue
        ABC_CHARS.contains(char = this.lowercaseChar()) -> YourChordsRuTheme.colors.red
        else -> YourChordsRuTheme.colors.green
    }
}