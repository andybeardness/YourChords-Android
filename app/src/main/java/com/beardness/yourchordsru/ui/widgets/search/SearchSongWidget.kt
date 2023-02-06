package com.beardness.yourchordsru.ui.widgets.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.ui.widgets.song.SongWidget

@Composable
fun SearchSongWidget(
    item: SearchResultSong,
    onClick: () -> Unit,
) {
    val songViewDto = item.viewDto()

    SongWidget(
        songViewDto = songViewDto,
        onClick = onClick,
        doesShowAuthor = true,
    )
}

@Composable
@Preview
fun Preview_SearchSongWidget_0() {
    SearchSongWidget(
        item = SearchResultSong(
            authorId = 0,
            songId = 0,
            songTitle = "Song title",
            songRating = 999,
            authorName = "Author name"
        ),
        onClick = {},
    )
}