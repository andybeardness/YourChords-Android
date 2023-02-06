package com.beardness.yourchordsru.presentation.core.authors

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto
import com.beardness.yourchordsru.presentation.core.dto.authorsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import javax.inject.Inject

class AuthorsCore @Inject constructor(
    private val authorsRepo: IAuthorsRepo,
): IAuthorsCore {

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