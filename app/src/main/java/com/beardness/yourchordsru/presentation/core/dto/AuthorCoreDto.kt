package com.beardness.yourchordsru.presentation.core.dto

import com.beardness.yourchordsru.presentation.data.repo.dto.AuthorRepoDto

data class AuthorCoreDto(
    val id: Int,
    val name: String,
)

fun AuthorRepoDto.coreDto(): AuthorCoreDto =
    AuthorCoreDto(
        id = this.id,
        name = this.name,
    )

fun List<AuthorRepoDto>.authorsRepoDtoToCoreDto(): List<AuthorCoreDto> =
    this.map { authorRepoDto -> authorRepoDto.coreDto() }
