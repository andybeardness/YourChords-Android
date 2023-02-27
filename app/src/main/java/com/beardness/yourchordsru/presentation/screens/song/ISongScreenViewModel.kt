package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ISongScreenViewModel {
    val authorName: StateFlow<String>
    val songTitle: StateFlow<String>
    val isSongFavorite: StateFlow<Boolean>
    val backgroundColor: StateFlow<Color>
    val textColor: StateFlow<Color>
    val chordsColor: StateFlow<Color>
    val chords: Flow<String>
    val isToolbarExpanded: StateFlow<Boolean>
    val textSize: StateFlow<Int>
    fun load(
        authorId: Int?,
        songId: Int?,
    )
    fun navigateBack()
    fun expandToolbar()
    fun textIncrease()
    fun textDecrease()
    fun changeBackgroundColor(color: Color)
    fun changeTextColor(color: Color)
    fun changeChordsColor(color: Color)
    fun changeSongFavorite()
}