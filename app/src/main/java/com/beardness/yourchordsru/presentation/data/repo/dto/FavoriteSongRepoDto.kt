package com.beardness.yourchordsru.presentation.data.repo.dto

import com.beardness.yourchordsru.presentation.data.datasource.dto.FavoriteSongSourceDto

data class FavoriteSongRepoDto(
    val id: Int,
    val authorId: Int,
    val songId: Int,
)

fun FavoriteSongSourceDto.repoDto(): FavoriteSongRepoDto =
    FavoriteSongRepoDto(
        id = this.id,
        authorId = this.authorId,
        songId = this.songId,
    )

fun List<FavoriteSongSourceDto>.favoriteSongSourceDtoToRepoDto(): List<FavoriteSongRepoDto> =
    this.map { favoriteSongSourceDto -> favoriteSongSourceDto.repoDto() }