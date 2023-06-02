package com.beardness.yourchordsru.utils.sorttype

enum class SongsSortType(val code: Int) {
    BY_NAME(code = 0),
    BY_RATING(code = 1),
}

fun Int.codeToSongsSortType(): SongsSortType =
    when (this) {
        0 -> SongsSortType.BY_NAME
        1 -> SongsSortType.BY_RATING
        else -> SongsSortType.BY_NAME
    }