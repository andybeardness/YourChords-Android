package com.beardness.yourchordsru.presentation.core.authors

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto
import kotlinx.coroutines.flow.StateFlow

interface IAuthorsCore {
    val authors: StateFlow<List<AuthorCoreDto>>
    suspend fun load()
    suspend fun authors(): List<AuthorCoreDto>
    suspend fun author(authorId: Int): AuthorCoreDto?
}