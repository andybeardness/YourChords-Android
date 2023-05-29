package com.beardness.yourchordsru.presentation.domain.core.type

import com.beardness.yourchordsru.presentation.data.dto.AuthorDataDto
import com.beardness.yourchordsru.presentation.data.dto.SongDataDto

sealed class SearchResultCoreType

class SongSearchResultCoreDto(
    val id: Int,
    val title: String,
    val ratingCount: Int,
) : SearchResultCoreType()

class AuthorSearchResultCoreDto(
    val id: Int,
    val name: String,
    val songsCount: Int,
    val ratingCount: Int,
) : SearchResultCoreType()

fun AuthorDataDto.toSearchResult(): AuthorSearchResultCoreDto =
    AuthorSearchResultCoreDto(
        id = id,
        name = name,
        songsCount = songsCount,
        ratingCount = ratingCount,
    )

fun SongDataDto.toSearchResult(): SongSearchResultCoreDto =
    SongSearchResultCoreDto(
        id = this.id,
        title = this.title,
        ratingCount = this.ratingCount,
    )