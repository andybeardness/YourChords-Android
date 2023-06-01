package com.beardness.yourchordsru.presentation.view.screen.authors

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.widget.AuthorWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.presentation.view.screen.authors.types.AuthorsSortType
import com.beardness.yourchordsru.theme.AppTheme
import com.beardness.your_chords_ru.R

@Composable
fun AuthorsScreen(
    viewModel: AuthorsScreenViewModelProtocol,
    navigateToSongs: (authorId: Int) -> Unit,
    navigateToSearch: () -> Unit,
) {

    val sortType by viewModel.sortType.collectAsState(initial = AuthorsSortType.DEFAULT)
    val authors by viewModel.authors.collectAsState(initial = emptyList())
    val favoriteAuthorsIds by viewModel.favoriteAuthorsIds.collectAsState(initial = emptyList())
    val favoriteSongsAuthorsIds by viewModel.favoriteSongsAuthorsIds.collectAsState(initial = emptyList())

    val sortIconColor by animateColorAsState(
        targetValue = when (sortType) {
            AuthorsSortType.DEFAULT -> MaterialTheme.colorScheme.onBackground
            AuthorsSortType.BY_FAVORITE -> AppTheme.colors.yellow
            AuthorsSortType.BY_RATING_COUNT -> AppTheme.colors.coral
            AuthorsSortType.BY_SONGS_COUNT -> AppTheme.colors.blue
        },
        animationSpec = tween(durationMillis = 250),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = "App Name",
            navigationButton = IconButton(
                imageVector = Icons.Rounded.Tag,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = null,
            ),
            actionButton = listOf(
                IconButton(
                    imageVector = Icons.Rounded.Search,
                    tint = MaterialTheme.colorScheme.onBackground,
                    onClick = { navigateToSearch() },
                ),
                IconButton(
                    imageVector = Icons.Rounded.TrendingUp,
                    tint = sortIconColor,
                    onClick = { viewModel.swapSortType() },
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

                val songsCountDescription = stringResource(id = R.string.songs_count, author.songsCount)
                val ratingCountDescription = stringResource(id = R.string.rating_count, author.ratingCount)

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