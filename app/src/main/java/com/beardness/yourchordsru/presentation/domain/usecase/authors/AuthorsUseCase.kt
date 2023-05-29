package com.beardness.yourchordsru.presentation.domain.usecase.authors

import com.beardness.yourchordsru.presentation.domain.core.authors.AuthorsCoreProtocol
import com.beardness.yourchordsru.presentation.domain.dto.AuthorDomainDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthorsUseCase @Inject constructor(
    private val authorsCore: AuthorsCoreProtocol,
) : AuthorsUseCaseProtocol {

    override val authors: Flow<List<AuthorDomainDto>> = authorsCore.authors
}