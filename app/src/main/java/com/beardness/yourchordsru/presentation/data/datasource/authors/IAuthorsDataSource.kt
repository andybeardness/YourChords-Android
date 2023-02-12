package com.beardness.yourchordsru.presentation.data.datasource.authors

import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto

interface IAuthorsDataSource {
    suspend fun authors(): List<AuthorSourceDto>
    suspend fun author(id: Int): AuthorSourceDto?
}