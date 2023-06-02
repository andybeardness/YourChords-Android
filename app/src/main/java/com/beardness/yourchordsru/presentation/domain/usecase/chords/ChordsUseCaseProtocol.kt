package com.beardness.yourchordsru.presentation.domain.usecase.chords

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import kotlinx.coroutines.flow.Flow

interface ChordsUseCaseProtocol {
    suspend fun chords(authorId: Int, songId: Int): String?

    val fontSize: Flow<Int>
    val viewMode: Flow<Int>

    val isMaxFontSize: Flow<Boolean>
    val isMinFontSize: Flow<Boolean>

    suspend fun increaseFontSize()
    suspend fun decreaseFontSize()
    suspend fun swapViewMode()
}
