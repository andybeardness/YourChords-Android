package com.beardness.yourchordsru.presentation.screens.chords

import com.beardness.yourchordsru.presentation.screens.dto.ChordViewDto
import kotlinx.coroutines.flow.StateFlow

interface IChordsScreenViewModel {
    val chords: StateFlow<List<ChordViewDto>>
    fun load(authorId: Int?, songId: Int?)
}