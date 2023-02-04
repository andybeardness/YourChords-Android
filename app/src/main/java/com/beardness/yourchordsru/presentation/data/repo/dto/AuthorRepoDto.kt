package com.beardness.yourchordsru.presentation.data.repo.dto

import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto

data class AuthorRepoDto(
    val id: Int,
    val name: String,
)

fun AuthorSourceDto.repoDto(): AuthorRepoDto =
    AuthorRepoDto(
        id = this.id,
        name = this.name,
    )

fun List<AuthorSourceDto>.authorsSourceDtoToRepoDto(): List<AuthorRepoDto> =
    this.map { authorSourceDto -> authorSourceDto.repoDto() }
