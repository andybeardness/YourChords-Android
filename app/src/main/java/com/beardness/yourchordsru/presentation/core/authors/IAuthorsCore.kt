package com.beardness.yourchordsru.presentation.core.authors

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto

interface IAuthorsCore {
    suspend fun authors(): List<AuthorCoreDto>
    suspend fun author(authorId: Int): AuthorCoreDto?
}