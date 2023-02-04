package com.beardness.yourchordsru.presentation.core.dto

import com.beardness.yourchordsru.presentation.data.repo.dto.SongRepoDto

data class SongCoreDto(
    val id: Int,
    val title: String,
    val chords: String,
    val rating: Int,
    val authorId: Int,
)

fun SongRepoDto.coreDto(): SongCoreDto =
    SongCoreDto(
        id = this.id,
        title = this.title,
        chords = this.chords,
        rating = this.rating,
        authorId = this.authorId,
    )

fun List<SongRepoDto>.songsRepoDtoToCoreDto(): List<SongCoreDto> =
    this.map { songRepoDto -> songRepoDto.coreDto() }
