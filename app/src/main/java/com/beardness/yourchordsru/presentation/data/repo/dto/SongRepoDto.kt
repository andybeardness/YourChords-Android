package com.beardness.yourchordsru.presentation.data.repo.dto

data class SongRepoDto(
    val id: Int,
    val title: String,
    val chords: String,
    val rating: Int,
    val authorId: Int,
)