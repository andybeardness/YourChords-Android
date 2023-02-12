package com.beardness.yourchordsru.presentation.data.datasource.dto

import com.beardness.yourchordsru.data.db.entity.FavoriteAuthorEntity

data class FavoriteAuthorSourceDto(
    val id: Int,
    val authorId: Int,
)

fun FavoriteAuthorEntity.sourceDto(): FavoriteAuthorSourceDto =
    FavoriteAuthorSourceDto(
        id = this.id,
        authorId = this.authorId,
    )

fun List<FavoriteAuthorEntity>.favoriteAuthorEntitiesToSourceDto() =
    this.map { favoriteAuthorEntity -> favoriteAuthorEntity.sourceDto() }
