package com.beardness.yourchordsru.presentation.view.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.widget.AuthorWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.SearchToolbarWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.SongWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.presentation.view.screen.search.types.SearchedAuthor
import com.beardness.yourchordsru.presentation.view.screen.search.types.SearchedSong
import com.beardness.your_chords_ru.R

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModelProtocol,
    navigateBack: () -> Unit,
    navigateSongs: (authorId: Int) -> Unit,
    navigateChords: (authorId: Int, songId: Int) -> Unit,
) {
    var input by remember { mutableStateOf(value = "") }
    val onValueChange: (update: String) -> Unit = { update ->
        input = update
        viewModel.updateInput(update = update)
    }

    val favoriteAuthorsIds by viewModel.favoriteAuthorsIds.collectAsState(initial = emptyList())
    val favoriteSongsIds by viewModel.favoriteSongsIds.collectAsState(initial = emptyList())
    val favoriteSongsAuthorsIds by viewModel.favoriteSongsAuthorsIds.collectAsState(initial = emptyList())

    val searched by viewModel.searched.collectAsState(initial = emptyList())

    val loading by viewModel.loading.collectAsState(initial = false)

    val onClickSearch: () -> Unit = {
        viewModel.search(input = input)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        SearchToolbarWidget(
            navigation = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = navigateBack,
            ),
            action = IconButton(
                imageVector = Icons.Rounded.Search,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = onClickSearch,
            ),
            input = input,
            onValueChange = onValueChange,
            onClickSearch = onClickSearch,
        )

        if (loading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.onPrimary,
                trackColor = MaterialTheme.colorScheme.primary
            )
        }

        LazyColumn {
            items(items = searched) { searched ->
                when (searched) {
                    is SearchedAuthor -> {
                        val author = searched.author

                        val favoriteType = when (author.id) {
                            in favoriteAuthorsIds -> FavoriteType.FAVORITE
                            in favoriteSongsAuthorsIds -> FavoriteType.PARTLY
                            else -> FavoriteType.DEFAULT
                        }

                        AuthorWidget(
                            name = author.name,
                            descriptions = listOf(
                                stringResource(id = R.string.songs_count, author.songsCount),
                                stringResource(id = R.string.rating_count, author.ratingCount),
                            ),
                            onClick = { navigateSongs(author.id) },
                            favoriteType = favoriteType,
                            onClickFavorite = { viewModel.swapAuthorFavorite(authorId = author.id) },
                        )
                    }
                    is SearchedSong -> {
                        val authorId = searched.authorId
                        val authorName = searched.authorName
                        val song = searched.song

                        val favoriteType = when (song.id) {
                            in favoriteSongsIds -> FavoriteType.FAVORITE
                            else -> FavoriteType.DEFAULT
                        }

                        SongWidget(
                            title = song.title,
                            descriptions = listOf(
                                stringResource(id = R.string.author_name, authorName),
                                stringResource(id = R.string.rating_count, song.ratingCount),
                            ),
                            onClick = { navigateChords(authorId, song.id) },
                            favoriteType = favoriteType,
                            onClickFavorite = { viewModel.swapSongFavorite(authorId = authorId, songId = song.id) },
                        )
                    }
                }
            }
        }
    }
}