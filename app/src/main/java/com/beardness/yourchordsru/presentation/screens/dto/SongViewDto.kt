package com.beardness.yourchordsru.presentation.screens.dto

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong

data class SongViewDto(
    val id: Int,
    val title: String,
    val chords: String,
    val rating: Int,
    val authorId: Int,
    val authorName: String,
)

fun SongCoreDto.viewDto(): SongViewDto =
    SongViewDto(
        id = this.id,
        title = this.title,
        chords = this.chords.replace(oldValue = "\\n", newValue = "\n"),
        rating = this.rating,
        authorId = this.authorId,
        authorName = this.authorName
    )

fun List<SongCoreDto>.songsCoreDtoToViewDto(): List<SongViewDto> =
    this.map { songCoreDto -> songCoreDto.viewDto() }

fun SearchResultSong.viewDto(): SongViewDto =
    SongViewDto(
        id = this.songId,
        title = this.songTitle,
        rating = this.songRating,
        chords = "",
        authorId = this.authorId,
        authorName = this.authorName,
    )