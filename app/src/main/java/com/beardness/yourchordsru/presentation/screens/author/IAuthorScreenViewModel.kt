package com.beardness.yourchordsru.presentation.screens.author

import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import kotlinx.coroutines.flow.StateFlow

interface IAuthorScreenViewModel {
    val songs: StateFlow<List<SongViewDto>>
    fun load(authorId: Int?)
}