package com.beardness.yourchordsru.presentation.view.screen.authors

import com.beardness.yourchordsru.presentation.entity.Author
import kotlinx.coroutines.flow.Flow

interface AuthorsScreenViewModelProtocol {
    val authors: Flow<List<Author>>
    val favoriteAuthorsIds: Flow<List<Int>>
    val favoriteSongsAuthorsIds: Flow<List<Int>>

    fun swapAuthorFavorite(authorId: Int)
}
