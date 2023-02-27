package com.beardness.yourchordsru.presentation.screens.dto.types

import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto

enum class AuthorsSortType(val code: Int) {
    DEFAULT(code = 0),
    FAVORITE_FIRST(code = 1),
}

fun Int.codeToAuthorsSortType(): AuthorsSortType =
    when (this) {
        0 -> AuthorsSortType.DEFAULT
        1 -> AuthorsSortType.FAVORITE_FIRST
        else -> AuthorsSortType.DEFAULT
    }

fun AuthorsSortType.toComparator() =
    when (this) {
        AuthorsSortType.DEFAULT ->
            compareBy<AuthorViewDto>(
                { authorViewDto -> authorViewDto.name },
            )
        AuthorsSortType.FAVORITE_FIRST ->
            compareBy<AuthorViewDto>(
                { authorViewDto -> !authorViewDto.isFavorite },
                { authorViewDto -> authorViewDto.name },
            )
    }