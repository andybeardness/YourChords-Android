package com.beardness.yourchordsru.presentation.data.datasource.dto

import com.beardness.yourchordsru.data.db.entity.FavoriteSongEntity

data class FavoriteSongSourceDto(
    val id: Int,
    val authorId: Int,
    val songId: Int,
)

fun FavoriteSongEntity.sourceDto(): FavoriteSongSourceDto =
    FavoriteSongSourceDto(
        id = this.id,
        authorId = this.authorId,
        songId = this.songId,
    )

fun List<FavoriteSongEntity>.favoriteSongEntitiesToSourceDto(): List<FavoriteSongSourceDto> =
    this.map { favoriteSongEntity -> favoriteSongEntity.sourceDto() }