package com.beardness.yourchordsru.presentation.view.screen.chords

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import kotlinx.coroutines.flow.Flow

interface ChordsScreenViewModelProtocol {
    fun setup(authorId: Int, songId: Int)
    val chords: Flow<String>
    val songTitle: Flow<String>
    val authorName: Flow<String>
    val viewMode: Flow<ChordsViewMode>
    val isMaxFontSize: Flow<Boolean>
    val isMinFontSize: Flow<Boolean>
    fun swapViewMode()
    fun increaseText()
    fun decreaseText()
}
