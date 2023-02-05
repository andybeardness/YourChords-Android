package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.StateFlow

interface ISongScreenViewModel {
    val chords: StateFlow<String>
    fun load(
        authorId: Int?,
        songId: Int?,
        backgroundColor: Color,
        textColor: Color,
    )
}