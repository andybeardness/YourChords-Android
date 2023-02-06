package com.beardness.yourchordsru.presentation.screens.dto

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor

data class AuthorViewDto(
    val id: Int,
    val name: String,
)

fun AuthorCoreDto.viewDto(): AuthorViewDto =
    AuthorViewDto(
        id = this.id,
        name = this.name,
    )

fun List<AuthorCoreDto>.authorsCoreDtoToViewDto(): List<AuthorViewDto> =
    this.map { authorCoreDto -> authorCoreDto.viewDto() }

fun SearchResultAuthor.viewDto(): AuthorViewDto =
    AuthorViewDto(
        id = this.authorId,
        name = this.authorName,
    )