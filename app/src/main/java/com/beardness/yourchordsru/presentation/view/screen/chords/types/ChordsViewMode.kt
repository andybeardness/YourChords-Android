package com.beardness.yourchordsru.presentation.view.screen.chords.types

enum class ChordsViewMode {
    LIGHT_BLUE,
    LIGHT_CORAL,
    DARK_ORANGE,
    DARK_GREEN,
    SEPIA;

    companion object {
        fun fromCode(code: Int): ChordsViewMode =
            when (code) {
                0 -> LIGHT_BLUE
                1 -> LIGHT_CORAL
                2 -> DARK_ORANGE
                3 -> DARK_GREEN
                4 -> SEPIA
                else -> LIGHT_BLUE
            }
    }

    fun toCode(): Int =
        when (this) {
            LIGHT_BLUE -> 0
            LIGHT_CORAL -> 1
            DARK_ORANGE -> 2
            DARK_GREEN -> 3
            SEPIA -> 4
        }
}