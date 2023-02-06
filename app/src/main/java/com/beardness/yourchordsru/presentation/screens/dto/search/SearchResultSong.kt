package com.beardness.yourchordsru.presentation.screens.dto.search

import com.beardness.yourchordsru.presentation.core.dto.SongCoreDto

data class SearchResultSong(
    val authorId: Int,
    val songId: Int,
    val songTitle: String,
    val songs_rating: Int,
) : SearchResult()

fun SongCoreDto.searchResultSong(): SearchResultSong =
    SearchResultSong(
        authorId = this.authorId,
        songId = this.id,
        songTitle = this.title,
        songs_rating = this.rating,
    )

fun List<SongCoreDto>.songsCoreDtoToSearchResultSong(): List<SearchResultSong> =
    this.map { songCoreDto -> songCoreDto.searchResultSong() }
