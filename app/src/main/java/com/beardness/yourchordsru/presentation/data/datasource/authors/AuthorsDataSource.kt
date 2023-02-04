package com.beardness.yourchordsru.presentation.data.datasource.authors

import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto
import com.beardness.yourchordsru.utils.csvreader.authors.IAuthorsCsvReader
import javax.inject.Inject

class AuthorsDataSource @Inject constructor(
    private val authorsCsvReader: IAuthorsCsvReader,
): IAuthorsDataSource {
    private val _authors = mutableListOf<AuthorSourceDto>()

    override fun load() {
        TODO("Not yet implemented")
    }

    override fun authors(): List<AuthorSourceDto> {
        return authorsCsvReader.read()
    }

    override fun author(id: Int): AuthorSourceDto {
        TODO("Not yet implemented")
    }

    private fun setup(authors: List<AuthorSourceDto>) {
        _authors.clear()
        _authors.addAll(elements = authors)
    }
}