package com.beardness.yourchordsru.presentation.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.beardness.yourchordsru.ui.widgets.author.AuthorWidget

@Composable
fun HomeScreen(
    viewModel: IHomeScreenViewModel,
) {
    val authors by
        viewModel
            .authors
            .collectAsState(initial = emptyList())

    LazyColumn {
        items(count = authors.size) { index ->
            val author = authors[index]
            AuthorWidget(
                authorViewDto = author,
                onClick = { authorId -> viewModel.navigateToAuthor(authorId = authorId) },
            )
        }
    }
}