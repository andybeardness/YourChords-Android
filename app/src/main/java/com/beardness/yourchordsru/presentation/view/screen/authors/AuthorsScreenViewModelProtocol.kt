package com.beardness.yourchordsru.presentation.view.screen.authors

import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.view.screen.authors.types.AuthorsSortType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface AuthorsScreenViewModelProtocol {
    val authors: Flow<List<Author>>
    val favoriteAuthorsIds: Flow<List<Int>>
    val favoriteSongsAuthorsIds: Flow<List<Int>>

    fun swapAuthorFavorite(authorId: Int)
    val sortType: StateFlow<AuthorsSortType>
    fun swapSortType()
    fun resetSortType()
}
