package com.beardness.yourchordsru.presentation.data.repo.dto

import com.beardness.yourchordsru.presentation.data.datasource.dto.FavoriteAuthorSourceDto

data class FavoriteAuthorRepoDto(
    val id: Int,
    val authorId: Int,
)

fun FavoriteAuthorSourceDto.repoDto(): FavoriteAuthorRepoDto =
    FavoriteAuthorRepoDto(
        id = this.id,
        authorId = this.authorId,
    )

fun List<FavoriteAuthorSourceDto>.favoriteAuthorSourceDtoToRepoDto(): List<FavoriteAuthorRepoDto> =
    this.map { favoriteAuthorSourceDto -> favoriteAuthorSourceDto.repoDto() }
