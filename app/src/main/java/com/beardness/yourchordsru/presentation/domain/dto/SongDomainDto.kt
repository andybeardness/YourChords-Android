package com.beardness.yourchordsru.presentation.domain.dto

import com.beardness.yourchordsru.presentation.data.dto.SongDataDto

class SongDomainDto(
    val id: Int,
    val title: String,
    val ratingCount: Int,
    val chords: String,
)

fun SongDataDto.toDomainDto() =
    SongDomainDto(
        id = this.id,
        title = this.title,
        ratingCount = this.ratingCount,
        chords = this.chords,
    )