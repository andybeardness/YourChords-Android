package com.beardness.yourchordsru.presentation.screens.dto.search

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto

data class SearchResultSong(
    val authorId: Int,
    val authorName: String,
    val songId: Int,
    val songTitle: String,
    val songRating: Int,
) : SearchResult()

fun SongCoreDto.searchResultSong(): SearchResultSong =
    SearchResultSong(
        authorId = this.authorId,
        authorName = this.authorName,
        songId = this.id,
        songTitle = this.title,
        songRating = this.rating,
    )

fun List<SongCoreDto>.songsCoreDtoToSearchResultSong(): List<SearchResultSong> =
    this.map { songCoreDto -> songCoreDto.searchResultSong() }
