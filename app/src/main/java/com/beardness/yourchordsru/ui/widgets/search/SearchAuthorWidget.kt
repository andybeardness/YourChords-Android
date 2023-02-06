package com.beardness.yourchordsru.ui.widgets.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchAuthorWidget(item: SearchResultAuthor) {
    Text(text = item.authorName, color = YourChordsRuTheme.colors.blue)
}