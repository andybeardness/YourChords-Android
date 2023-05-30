package com.beardness.yourchordsru.presentation.domain.core.authors

import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.entity.Author
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class AuthorsCore @Inject constructor(
    private val authorsCsvReader: AuthorsCsvReaderProtocol,
) : AuthorsCoreProtocol {

    private val _authors = MutableStateFlow(value = emptyList<Author>())
    override val authors: StateFlow<List<Author>> = _authors.asStateFlow()

    override suspend fun init() {
        val authors =
            authorsCsvReader
                .read()

        _authors.emit(value = authors)
    }

    override suspend fun author(authorId: Int): Author? {
        return _authors
            .value
            .firstOrNull { author -> author.id == authorId }
    }
}