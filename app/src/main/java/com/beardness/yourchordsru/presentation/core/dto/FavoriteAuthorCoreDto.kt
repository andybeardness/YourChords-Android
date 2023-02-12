package com.beardness.yourchordsru.presentation.core.dto

import com.beardness.yourchordsru.presentation.data.repo.dto.FavoriteAuthorRepoDto

data class FavoriteAuthorCoreDto(
    val id: Int,
    val authorId: Int,
)

fun FavoriteAuthorRepoDto.coreDto(): FavoriteAuthorCoreDto =
    FavoriteAuthorCoreDto(
        id = this.id,
        authorId = this.authorId,
    )

fun List<FavoriteAuthorRepoDto>.favoriteAuthorRepoDtoToCoreDto(): List<FavoriteAuthorCoreDto> =
    this.map { favoriteAuthorRepoDto -> favoriteAuthorRepoDto.coreDto() }
