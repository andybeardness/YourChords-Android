package com.beardness.yourchordsru.presentation.screens.author

import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.utils.sorttype.SongsSortType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IAuthorScreenViewModel {
    val authorName: StateFlow<String>
    val isFavorite: StateFlow<Boolean>
    val songs: StateFlow<List<SongViewDto>>
    val songsSortType: StateFlow<SongsSortType>
    val favoriteSongsIds: Flow<List<Int>>
    val scrollUp: StateFlow<Boolean?>
    fun load(authorId: Int?)
    fun navigateToSong(authorId: Int, songId: Int)
    fun navigateToSearch()
    fun navigateBack()
    fun updateScrollPosition(firstVisibleItemIndex: Int)
    fun switchSortType()
    fun changeAuthorFavorite()
    fun changeSongFavorite(songId: Int)
    fun makeFavorite(authorId: Int, songId: Int)
    fun removeFavorite(authorId: Int, songId: Int)
}