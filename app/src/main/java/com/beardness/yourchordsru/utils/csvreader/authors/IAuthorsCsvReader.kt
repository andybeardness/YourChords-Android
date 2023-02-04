package com.beardness.yourchordsru.utils.csvreader.authors

import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto

interface IAuthorsCsvReader {
    fun read(): List<AuthorSourceDto>
}