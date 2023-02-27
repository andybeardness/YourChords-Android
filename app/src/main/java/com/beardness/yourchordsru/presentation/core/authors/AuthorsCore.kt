package com.beardness.yourchordsru.presentation.core.authors

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto
import com.beardness.yourchordsru.presentation.core.dto.authorsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class AuthorsCore @Inject constructor(
    private val authorsRepo: IAuthorsRepo,
): IAuthorsCore {

    private val _authors = MutableStateFlow(value = emptyList<AuthorCoreDto>())
    override val authors: StateFlow<List<AuthorCoreDto>> = _authors.asStateFlow()

    override suspend fun load() {
        val currentAuthors =
            authorsRepo
                .authors()
                .authorsRepoDtoToCoreDto()
                .sortedBy { authorCoreDto -> authorCoreDto.name }

        _authors.emit(value = currentAuthors)
    }

    override suspend fun authors(): List<AuthorCoreDto> {
        return authorsRepo
            .authors()
            .authorsRepoDtoToCoreDto()
    }

    override suspend fun author(authorId: Int): AuthorCoreDto? {
        return authorsRepo
            .author(authorId = authorId)
            ?.coreDto()
    }
}