package com.beardness.yourchordsru.presentation.screens.search

import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import kotlinx.coroutines.flow.StateFlow

interface ISearchScreenViewModel {
    val foundSongs: StateFlow<List<SongViewDto>>
    fun search(pattern: String)
    fun navigateToSong(authorId: Int, songId: Int)
}