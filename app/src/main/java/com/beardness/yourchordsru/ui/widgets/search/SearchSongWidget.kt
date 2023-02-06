package com.beardness.yourchordsru.ui.widgets.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchSongWidget(item: SearchResultSong) {
    Text(text = item.songTitle, color = YourChordsRuTheme.colors.red)
}