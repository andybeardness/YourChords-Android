package com.beardness.yourchordsru.ui.widgets.author

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto

@Composable
fun AuthorCollectionWidget(
    modifier: Modifier,
    lazyListState: LazyListState,
    authors: List<AuthorViewDto>,
    onCLick: (authorId: Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        items(count = authors.size) { index ->
            val author = authors[index]

            AuthorWidget(
                authorViewDto = author,
                onClick = { onCLick(author.id) },
            )
        }
    }
}