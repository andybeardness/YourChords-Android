package com.beardness.yourchordsru.presentation.data.reader.csv.authors

import com.beardness.yourchordsru.presentation.entity.Author

interface AuthorsCsvReaderProtocol {
    fun read(): List<Author>
}