package com.beardness.yourchordsru.presentation.screens.dto.search

import com.beardness.yourchordsru.presentation.core.dto.AuthorCoreDto

data class SearchResultAuthor(
    val authorId: Int,
    val authorName: String,
) : SearchResult()

fun AuthorCoreDto.searchResultAuthor(): SearchResultAuthor =
    SearchResultAuthor(
        authorId = this.id,
        authorName = this.name,
    )

fun List<AuthorCoreDto>.authorsCoreDtoToSearchResultAuthor(): List<SearchResultAuthor> =
    this.map { authorCoreDto -> authorCoreDto.searchResultAuthor() }