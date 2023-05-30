package com.beardness.yourchordsru.presentation.view.screen.songs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.widget.SongWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton

@Composable
fun SongScreen(
    viewModel: SongsScreenViewModelProtocol,
    navigateBack: () -> Unit,
    navigateChords: (authorId: Int, songId: Int) -> Unit,
) {

    val authorId by viewModel.authorId.collectAsState(initial = -1)
    val authorName by viewModel.authorName.collectAsState(initial = "")
    val authorFavoriteType by viewModel.authorFavoriteType.collectAsState(initial = FavoriteType.DEFAULT)
    val songs by viewModel.songs.collectAsState(initial = emptyList())
    val favoriteSongsIds by viewModel.favoriteSongsIds.collectAsState(initial = emptyList())

    val authorRatingSortIconColor = Color.Yellow

    val authorFavoriteIconColor = when (authorFavoriteType) {
        FavoriteType.DEFAULT -> Color.White
        FavoriteType.FAVORITE -> Color.Yellow
        FavoriteType.PARTLY -> Color.Yellow
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = authorName,
            navigationButton = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = authorFavoriteIconColor,
                onClick = navigateBack
            ),
            actionButton = listOf(
                IconButton(
                    imageVector = Icons.Rounded.TrendingUp,
                    tint = authorRatingSortIconColor,
                    onClick = navigateBack
                ),
                IconButton(
                    imageVector = Icons.Rounded.ArrowBackIos,
                    tint = Color.White,
                    onClick = navigateBack
                ),
            )
        )

        LazyColumn {
            items(items = songs) { song ->
                val favoriteType = when (song.id) {
                    in favoriteSongsIds -> FavoriteType.FAVORITE
                    else -> FavoriteType.DEFAULT
                }

                SongWidget(
                    title = song.title,
                    description = song.ratingCount.toString(),
                    onClick = { navigateChords(authorId, song.id) },
                    favoriteType = favoriteType,
                    onClickFavorite = {
                        viewModel.swapSongFavoriteType(
                            authorId = authorId,
                            songId = song.id,
                        )
                    },
                )
            }
        }
    }
}