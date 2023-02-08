package com.beardness.yourchordsru.presentation.screens.dto

data class ChordViewDto(
    val name: String,
)

fun String.chordViewDto(): ChordViewDto =
    ChordViewDto(
        name = this.trim(),
    )

fun List<String>.stringChordNamesToChordViewDto(): List<ChordViewDto> =
    this.map { name -> name.chordViewDto() }

