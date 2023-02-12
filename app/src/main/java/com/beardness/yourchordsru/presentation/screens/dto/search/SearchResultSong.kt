package com.beardness.yourchordsru.presentation.screens.dto.search

data class SearchResultSong(
    val authorId: Int,
    val authorName: String,
    val songId: Int,
    val songTitle: String,
    val songRating: Int,
    val isFavorite: Boolean,
) : SearchResult()
