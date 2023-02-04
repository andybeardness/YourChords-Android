package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontFamily
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SongScreen(
    viewModel: ISongScreenViewModel,
) {
    val chords by viewModel.chords.collectAsState()

    Text(
        text = chords,
        color = YourChordsRuTheme.colors.text,
        fontFamily = FontFamily.Monospace,
    )
}