package com.beardness.yourchordsru.presentation.domain.core.type

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