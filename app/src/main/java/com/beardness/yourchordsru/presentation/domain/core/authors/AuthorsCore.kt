package com.beardness.yourchordsru.presentation.domain.core.authors

import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.domain.dto.AuthorDomainDto
import com.beardness.yourchordsru.presentation.domain.dto.toDomainDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class AuthorsCore @Inject constructor(
    private val authorsCsvReader: AuthorsCsvReaderProtocol,
) : AuthorsCoreProtocol {

    private val _authors = MutableStateFlow(value = emptyList<AuthorDomainDto>())
    override val authors: StateFlow<List<AuthorDomainDto>> = _authors.asStateFlow()

    override suspend fun init() {
        val authors =
            authorsCsvReader
                .read()
                .map { authorDataDto -> authorDataDto.toDomainDto() }

        _authors.emit(value = authors)
    }

    override suspend fun author(authorId: Int): AuthorDomainDto? {
        return _authors
            .value
            .firstOrNull { authorCoreDto -> authorCoreDto.id == authorId }
    }
}