package com.beardness.yourchordsru.presentation.data.repo.dto

import com.beardness.yourchordsru.presentation.data.datasource.dto.SongSourceDto

data class SongRepoDto(
    val id: Int,
    val title: String,
    val chords: String,
    val rating: Int,
    val authorId: Int,
)

fun SongSourceDto.repoDto(): SongRepoDto =
    SongRepoDto(
        id = this.id,
        title = this.title,
        chords = this.chords,
        rating = this.rating,
        authorId = this.authorId,
    )

fun List<SongSourceDto>.songSourceDtoToRepoDto(): List<SongRepoDto> =
    this.map { songSourceDto -> songSourceDto.repoDto() }