package com.beardness.yourchordsru.presentation.data.datasource.authors

import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto
import com.beardness.yourchordsru.utils.csvreader.authors.IAuthorsCsvReader
import javax.inject.Inject

class AuthorsDataSource @Inject constructor(
    private val authorsCsvReader: IAuthorsCsvReader,
): IAuthorsDataSource {
    override suspend fun authors(): List<AuthorSourceDto> {
        return authorsCsvReader.read()
    }

    override suspend fun author(id: Int): AuthorSourceDto? {
        return authorsCsvReader
            .read()
            .firstOrNull { authorSourceDto -> authorSourceDto.id == id }
    }
}