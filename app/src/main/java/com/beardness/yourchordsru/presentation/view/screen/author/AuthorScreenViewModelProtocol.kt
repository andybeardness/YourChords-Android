package com.beardness.yourchordsru.presentation.view.screen.author

import com.beardness.yourchordsru.presentation.view.dto.AuthorViewDto
import kotlinx.coroutines.flow.Flow

interface AuthorScreenViewModelProtocol {
    val authors: Flow<List<AuthorViewDto>>

    fun swapAuthorFavorite(authorId: Int)
}
