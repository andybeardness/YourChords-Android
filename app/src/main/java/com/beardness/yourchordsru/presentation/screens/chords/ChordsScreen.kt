package com.beardness.yourchordsru.presentation.screens.chords

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun ChordsScreen(
    viewModel: IChordsScreenViewModel
) {
    val chords by viewModel.chords.collectAsState()

    LazyColumn {
        items(count = chords.size) { index ->
            val chord = chords[index]

            Text(
                text = chord.name,
                color = YourChordsRuTheme.colors.text,
            )
        }
    }
}