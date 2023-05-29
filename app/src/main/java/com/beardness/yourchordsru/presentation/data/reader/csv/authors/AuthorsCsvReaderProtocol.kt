package com.beardness.yourchordsru.presentation.data.reader.csv.authors

import com.beardness.yourchordsru.presentation.data.dto.AuthorDataDto

interface AuthorsCsvReaderProtocol {
    fun read(): List<AuthorDataDto>
}