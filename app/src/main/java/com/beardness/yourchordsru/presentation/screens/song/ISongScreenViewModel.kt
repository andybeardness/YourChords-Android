package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.StateFlow

interface ISongScreenViewModel {
    val authorName: StateFlow<String>
    val songTitle: StateFlow<String>
    val chords: StateFlow<String>
    val isToolbarExpanded: StateFlow<Boolean>
    fun load(
        authorId: Int?,
        songId: Int?,
        backgroundColor: Color,
        textColor: Color,
    )
    fun navigateBack()
    fun expandToolbar()
}