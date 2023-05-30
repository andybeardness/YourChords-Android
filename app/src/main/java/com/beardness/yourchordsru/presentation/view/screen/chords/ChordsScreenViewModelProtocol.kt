package com.beardness.yourchordsru.presentation.view.screen.chords

import com.beardness.yourchordsru.presentation.entity.Song
import kotlinx.coroutines.flow.Flow

interface ChordsScreenViewModelProtocol {
    fun setup(authorId: Int, songId: Int)
    val chords: Flow<String>
    val songTitle: Flow<String>
    val authorName: Flow<String>
}
