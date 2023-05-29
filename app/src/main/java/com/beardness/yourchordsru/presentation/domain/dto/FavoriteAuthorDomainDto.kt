package com.beardness.yourchordsru.presentation.domain.dto

import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteAuthorEntity

class FavoriteAuthorDomainDto(
    val id: Int,
    val authorId: Int,
)

fun FavoriteAuthorEntity.toDomainDto(): FavoriteAuthorDomainDto =
    FavoriteAuthorDomainDto(
        id = this.id,
        authorId = this.authorId,
    )