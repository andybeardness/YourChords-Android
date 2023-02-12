package com.beardness.yourchordsru.presentation.screens.dto.search

data class SearchResultAuthor(
    val authorId: Int,
    val authorName: String,
    val isFavorite: Boolean,
) : SearchResult()