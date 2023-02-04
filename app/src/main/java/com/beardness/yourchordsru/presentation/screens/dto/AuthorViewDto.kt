package com.beardness.yourchordsru.presentation.screens.dto

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto

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