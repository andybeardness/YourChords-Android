package com.beardness.yourchordsru.presentation.domain.dto

import com.beardness.yourchordsru.presentation.data.dto.AuthorDataDto

class AuthorDomainDto(
    val id: Int,
    val name: String,
    val songsCount: Int,
    val ratingCount: Int,
)

fun AuthorDataDto.toDomainDto(): AuthorDomainDto =
    AuthorDomainDto(
        id = this.id,
        name = this.name,
        songsCount = this.songsCount,
        ratingCount = this.ratingCount,
    )