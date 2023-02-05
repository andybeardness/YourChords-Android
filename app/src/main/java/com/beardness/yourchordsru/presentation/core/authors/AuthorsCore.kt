package com.beardness.yourchordsru.presentation.core.authors

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto
import com.beardness.yourchordsru.presentation.core.dto.authorsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class AuthorsCore @Inject constructor(
    private val authorsRepo: IAuthorsRepo,
): IAuthorsCore {

    private val _authors = MutableStateFlow<List<AuthorCoreDto>>(value = emptyList())
    override val authors = _authors.asStateFlow()

    override suspend fun load() {
        val authors =
            authorsRepo
                .authors()
                .authorsRepoDtoToCoreDto()

        _authors.emit(value = authors)
    }

    override suspend fun author(authorId: Int): AuthorCoreDto? {
        return authorsRepo
            .author(authorId = authorId)
            ?.coreDto()
    }
}