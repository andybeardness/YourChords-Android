package com.beardness.yourchordsru.presentation.view.screen.authors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.widget.AuthorWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton

@Composable
fun AuthorsScreen(
    viewModel: AuthorsScreenViewModelProtocol,
    navigateToSongs: (authorId: Int) -> Unit,
    navigateToSearch: () -> Unit,
) {
    val authors by viewModel.authors.collectAsState(initial = emptyList())
    val favoriteAuthorsIds by viewModel.favoriteAuthorsIds.collectAsState(initial = emptyList())
    val favoriteSongsAuthorsIds by viewModel.favoriteSongsAuthorsIds.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = "App Name",
            navigationButton = IconButton(
                imageVector = Icons.Rounded.Tag,
                tint = Color.White,
                onClick = null,
            ),
            actionButton = listOf(
                IconButton(
                    imageVector = Icons.Rounded.StarBorder,
                    tint = Color.White,
                    onClick = {},
                ),

                IconButton(
                    imageVector = Icons.Rounded.Search,
                    tint = Color.White,
                    onClick = { navigateToSearch() },
                ),
            ),
        )

        LazyColumn {
            items(items = authors) { author ->
                val favoriteType = when (author.id) {
                    in favoriteAuthorsIds -> FavoriteType.FAVORITE
                    in favoriteSongsAuthorsIds -> FavoriteType.PARTLY
                    else -> FavoriteType.DEFAULT
                }

                val songsCountDescription = "Songs: ${author.songsCount}"
                val ratingCountDescription = "Rating: ${author.ratingCount}"

                val descriptions = listOf(
                    songsCountDescription,
                    ratingCountDescription,
                )

                AuthorWidget(
                    name = author.name,
                    descriptions = descriptions,
                    onClick = { navigateToSongs(author.id) },
                    favoriteType = favoriteType,
                    onClickFavorite = { viewModel.swapAuthorFavorite(authorId = author.id) },
                )
            }
        }
    }
}