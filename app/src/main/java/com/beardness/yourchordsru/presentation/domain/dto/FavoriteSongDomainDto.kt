package com.beardness.yourchordsru.presentation.domain.dto

import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteSongEntity

class FavoriteSongDomainDto(
    val id: Int,
    val authorId: Int,
    val songId: Int,
)

fun FavoriteSongEntity.toDomainDto(): FavoriteSongDomainDto =
    FavoriteSongDomainDto(
        id = this.id,
        authorId = this.authorId,
        songId = this.songId,
    )