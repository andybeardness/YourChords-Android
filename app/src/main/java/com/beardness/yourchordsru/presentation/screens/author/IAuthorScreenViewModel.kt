package com.beardness.yourchordsru.presentation.screens.author

import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.utils.sorttype.SongsSortType
import kotlinx.coroutines.flow.StateFlow

interface IAuthorScreenViewModel {
    val authorName: StateFlow<String>
    val songs: StateFlow<List<SongViewDto>>
    val songsSortType: StateFlow<SongsSortType>
    val scrollUp: StateFlow<Boolean?>
    fun load(authorId: Int?)
    fun navigateToSong(authorId: Int, songId: Int)
    fun navigateToSearch()
    fun navigateBack()
    fun updateScrollPosition(firstVisibleItemIndex: Int)
    fun switchSortType()

}