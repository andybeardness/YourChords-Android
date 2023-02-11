package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.StateFlow

interface ISongScreenViewModel {
    val authorName: StateFlow<String>
    val songTitle: StateFlow<String>
    val backgroundColor: StateFlow<Color>
    val textColor: StateFlow<Color>
    val chordsColor: StateFlow<Color>
    val chords: StateFlow<String>
    val isToolbarExpanded: StateFlow<Boolean>
    val initialTextSize: StateFlow<Int>
    val textSize: StateFlow<Int>
    fun load(
        authorId: Int?,
        songId: Int?,
    )
    fun navigateBack()
    fun expandToolbar()
    fun textIncrease()
    fun textDecrease()
    fun textReset()
}