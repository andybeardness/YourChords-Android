package com.beardness.yourchordsru.presentation.screens.dto

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor

data class AuthorViewDto(
    val id: Int,
    val name: String,
    val isFavorite: Boolean,
)

fun AuthorCoreDto.viewDto(
    isFavorite: Boolean = false,
): AuthorViewDto =
    AuthorViewDto(
        id = this.id,
        name = this.name,
        isFavorite = isFavorite,
    )

fun List<AuthorCoreDto>.authorsCoreDtoToViewDto(): List<AuthorViewDto> =
    this.map { authorCoreDto -> authorCoreDto.viewDto() }

fun SearchResultAuthor.viewDto(isFavorite: Boolean = false): AuthorViewDto =
    AuthorViewDto(
        id = this.authorId,
        name = this.authorName,
        isFavorite = isFavorite,
    )