package com.beardness.yourchordsru.presentation.data.repo.authors

import com.beardness.yourchordsru.presentation.data.repo.dto.AuthorRepoDto

interface IAuthorsRepo {
    suspend fun authors(): List<AuthorRepoDto>
    suspend fun author(authorId: Int): AuthorRepoDto?
}