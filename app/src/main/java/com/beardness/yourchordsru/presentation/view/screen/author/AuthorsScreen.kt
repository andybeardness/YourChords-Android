package com.beardness.yourchordsru.presentation.view.screen.author

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.view.compose.widget.AuthorWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
import com.beardness.yourchordsru.presentation.view.dto.ToolbarButtonViewDto

@Composable
fun AuthorsScreen(
    viewModel: AuthorScreenViewModelProtocol,
    navigateToSongs: (authorId: Int) -> Unit,
    navigateToSearch: () -> Unit,
) {
    val authors by viewModel.authors.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = "App Name",
            navigationButton = ToolbarButtonViewDto(
                imageVector = Icons.Rounded.PersonOutline,
                tint = Color.White,
                onClick = null,
            ),
            actionButton = listOf(
                ToolbarButtonViewDto(
                    imageVector = Icons.Rounded.StarBorder,
                    tint = Color.White,
                    onClick = {},
                ),

                ToolbarButtonViewDto(
                    imageVector = Icons.Rounded.Search,
                    tint = Color.White,
                    onClick = { navigateToSearch() },
                ),
            ),
        )

        LazyColumn {
            items(items = authors) { author ->
                AuthorWidget(
                    name = author.name,
                    songsCount = author.songsCount,
                    onClick = { navigateToSongs(author.id) },
                    favoriteType = author.favoriteType,
                    onClickFavorite = { viewModel.swapAuthorFavorite(authorId = author.id) },
                )
            }
        }
    }
}