package com.beardness.yourchordsru.presentation.domain.usecase.authors

import com.beardness.yourchordsru.presentation.domain.dto.AuthorDomainDto
import kotlinx.coroutines.flow.Flow

interface AuthorsUseCaseProtocol {
    val authors: Flow<List<AuthorDomainDto>>
}
