package com.beardness.yourchordsru.presentation.core.dto

import com.beardness.yourchordsru.presentation.data.repo.dto.FavoriteSongRepoDto

data class FavoriteSongCoreDto(
    val id: Int,
    val authorId: Int,
    val songId: Int,
)

fun FavoriteSongRepoDto.coreDto(): FavoriteSongCoreDto =
    FavoriteSongCoreDto(
        id = this.id,
        authorId = this.authorId,
        songId = this.songId,
    )

fun List<FavoriteSongRepoDto>.favoriteSongRepoDtoToCoreDto(): List<FavoriteSongCoreDto> =
    this.map { favoriteSongRepoDto -> favoriteSongRepoDto.coreDto() }