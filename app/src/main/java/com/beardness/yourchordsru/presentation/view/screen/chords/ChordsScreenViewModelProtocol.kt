package com.beardness.yourchordsru.presentation.view.screen.chords

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ChordsScreenViewModelProtocol {
    fun setup(authorId: Int, songId: Int)
    val chords: Flow<String>
    val songTitle: Flow<String>
    val authorName: Flow<String>
    fun swapViewMode()
    fun increaseText()
    fun decreaseText()
    val viewMode: StateFlow<ChordsViewMode>
}
