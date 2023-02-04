package com.beardness.yourchordsru.presentation.data.datasource.authors

import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto

interface IAuthorsDataSource {
    fun load()
    fun authors(): List<AuthorSourceDto>
    fun author(id: Int): AuthorSourceDto
}