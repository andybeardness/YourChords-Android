package com.beardness.yourchordsru.presentation.domain.core.authors

import com.beardness.yourchordsru.presentation.domain.dto.AuthorDomainDto
import kotlinx.coroutines.flow.StateFlow

interface AuthorsCoreProtocol {
    val authors: StateFlow<List<AuthorDomainDto>>
    suspend fun init()
    suspend fun author(authorId: Int): AuthorDomainDto?
}