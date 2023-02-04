package com.beardness.yourchordsru.presentation.screens.song

import kotlinx.coroutines.flow.StateFlow

interface ISongScreenViewModel {
    val chords: StateFlow<String>
    fun load(authorId: Int?, songId: Int?)
}