package com.beardness.yourchordsru.presentation.domain.usecase.authors

import com.beardness.yourchordsru.presentation.entity.Author
import kotlinx.coroutines.flow.Flow

interface AuthorsUseCaseProtocol {
    val authors: Flow<List<Author>>

    suspend fun author(authorId: Int): Author?
    suspend fun authors(): List<Author>
}
