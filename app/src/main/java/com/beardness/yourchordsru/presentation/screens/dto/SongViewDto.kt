package com.beardness.yourchordsru.presentation.screens.dto

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto

data class SongViewDto(
    val id: Int,
    val title: String,
    val chords: String,
    val rating: Int,
    val authorId: Int,
)

fun SongCoreDto.viewDto(): SongViewDto =
    SongViewDto(
        id = this.id,
        title = this.title,
        chords = this.chords.replace(oldValue = "\\n", newValue = "\n"),
        rating = this.rating,
        authorId = this.authorId,
    )

fun List<SongCoreDto>.songsCoreDtoToViewDto(): List<SongViewDto> =
    this.map { songCoreDto -> songCoreDto.viewDto() }
