package com.beardness.yourchordsru.config

object ChordsConfig {
    val BACKGROUND_COLORS = setOf(
        0xFFFAFAFA,
        0xFFF5F5F5,
        0xFF121212,
        0xFF272727,
    )

    val TEXT_COLORS = setOf(
        0xFF000000,
        0xFFFFFFFF,
    )

    val CHORDS_COLORS = setOf(
        0xFF007AFF,
        0xFF34C759,
        0xFFFFCC00,
        0xFFFF3B30,
    )

    const val DEFAULT_BACKGROUND_COLOR = 0xFFFAFAFA
    const val DEFAULT_TEXT_COLOR = 0xFF000000
    const val DEFAULT_CHORDS_COLOR = 0xFF007AFF
    const val DEFAULT_FONT_SIZE = 14

    const val DEFAULT_THEME_CODE = 0
    const val DEFAULT_AUTHOR_SORT_TYPE = 0
    const val DEFAULT_SONG_SORT_TYPE = 0

    const val MAX_FONT_SIZE_PX = 24
    const val MIN_FONT_SIZE_PX = 8
}