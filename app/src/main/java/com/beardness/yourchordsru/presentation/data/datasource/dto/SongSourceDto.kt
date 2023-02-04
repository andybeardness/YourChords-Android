package com.beardness.yourchordsru.presentation.data.datasource.dto

data class SongSourceDto(
    val id: Int,
    val title: String,
    val chords: String,
    val rating: Int,
    val authorId: Int,
)
