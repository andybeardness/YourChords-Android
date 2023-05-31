package com.beardness.yourchordsru.presentation.view.screen.songs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
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
import com.beardness.yourchordsru.presentation.view.screen.songs.types.SongsSortType

@Composable
fun SongScreen(
    viewModel: SongsScreenViewModelProtocol,
    navigateBack: () -> Unit,
    navigateChords: (authorId: Int, songId: Int) -> Unit,
) {

    val sortType by viewModel.sortType.collectAsState(initial = SongsSortType.DEFAULT)
    val authorId by viewModel.authorId.collectAsState(initial = -1)
    val authorName by viewModel.authorName.collectAsState(initial = "")
    val authorFavoriteType by viewModel.authorFavoriteType.collectAsState(initial = FavoriteType.DEFAULT)
    val songs by viewModel.songs.collectAsState(initial = emptyList())
    val favoriteSongsIds by viewModel.favoriteSongsIds.collectAsState(initial = emptyList())

    val authorFavoriteIcon = when (authorFavoriteType) {
        FavoriteType.DEFAULT -> Icons.Rounded.StarBorder
        FavoriteType.FAVORITE -> Icons.Rounded.Star
        FavoriteType.PARTLY -> Icons.Rounded.StarBorder
    }

    val authorFavoriteIconColor = when (authorFavoriteType) {
        FavoriteType.DEFAULT -> Color.White
        FavoriteType.FAVORITE -> Color.Yellow
        FavoriteType.PARTLY -> Color.Yellow
    }

    val sortIconColor = when (sortType) {
        SongsSortType.DEFAULT -> Color.White
        SongsSortType.BY_FAVORITE -> Color.Yellow
        SongsSortType.BY_RATING_COUNT -> Color.Red
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = authorName,
            navigationButton = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = Color.White,
                onClick = navigateBack
            ),
            actionButton = listOf(
                IconButton(
                    imageVector = authorFavoriteIcon,
                    tint = authorFavoriteIconColor,
                    onClick = {},
                ),
                IconButton(
                    imageVector = Icons.Rounded.TrendingUp,
                    tint = sortIconColor,
                    onClick = { viewModel.swapSortType() },
                ),
            )
        )

        LazyColumn {
            items(items = songs) { song ->
                val favoriteType = when (song.id) {
                    in favoriteSongsIds -> FavoriteType.FAVORITE
                    else -> FavoriteType.DEFAULT
                }

                val songRatingDescription = "Rating: ${song.ratingCount}"

                val descriptions = listOf(
                    songRatingDescription
                )

                SongWidget(
                    title = song.title,
                    descriptions = descriptions,
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