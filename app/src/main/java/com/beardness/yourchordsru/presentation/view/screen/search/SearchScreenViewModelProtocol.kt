package com.beardness.yourchordsru.presentation.view.screen.search

import com.beardness.yourchordsru.presentation.view.screen.search.types.Searched
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SearchScreenViewModelProtocol {

    val input: StateFlow<String>

    val searched: Flow<List<Searched>>

    val favoriteAuthorsIds: Flow<List<Int>>
    val favoriteSongsIds: Flow<List<Int>>
    val favoriteSongsAuthorsIds: Flow<List<Int>>

    val loading: StateFlow<Boolean>

    fun search(input: String)
    fun swapAuthorFavorite(authorId: Int)
    fun swapSongFavorite(authorId: Int, songId: Int)
    fun updateInput(update: String)
}
