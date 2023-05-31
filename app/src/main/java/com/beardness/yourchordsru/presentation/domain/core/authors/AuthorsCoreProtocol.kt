package com.beardness.yourchordsru.presentation.domain.core.authors

import com.beardness.yourchordsru.presentation.entity.Author
import kotlinx.coroutines.flow.StateFlow

interface AuthorsCoreProtocol {
    val authors: StateFlow<List<Author>>
    suspend fun init()
    suspend fun author(authorId: Int): Author?
    suspend fun authors(): List<Author>
}