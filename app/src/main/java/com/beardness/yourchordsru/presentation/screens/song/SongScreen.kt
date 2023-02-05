package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.beardness.yourchordsru.ui.widgets.chords.ChordsWidget

@Composable
fun SongScreen(
    viewModel: ISongScreenViewModel,
) {
    val chords by viewModel.chords.collectAsState()

    ChordsWidget(
        chords = chords,
    )
}