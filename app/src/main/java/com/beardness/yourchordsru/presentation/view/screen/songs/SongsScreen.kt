package com.beardness.yourchordsru.presentation.view.screen.songs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.beardness.your_chords_ru.R
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.widget.SongWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.presentation.view.screen.songs.types.SongsSortType
import com.beardness.yourchordsru.theme.AppTheme

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

    val authorFavoriteIconColor by animateColorAsState(
        targetValue = when (authorFavoriteType) {
            FavoriteType.DEFAULT -> MaterialTheme.colorScheme.onBackground.copy(alpha = .3f)
            FavoriteType.FAVORITE -> AppTheme.colors.yellow
            FavoriteType.PARTLY -> AppTheme.colors.yellow
        }, animationSpec = tween(durationMillis = 250)
    )


    val sortIconColor by animateColorAsState(
        targetValue = when (sortType) {
            SongsSortType.DEFAULT -> MaterialTheme.colorScheme.onBackground
            SongsSortType.BY_FAVORITE -> AppTheme.colors.yellow
            SongsSortType.BY_RATING_COUNT -> AppTheme.colors.purple
        },
        animationSpec = tween(durationMillis = 250),
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ToolbarWidget(
            title = authorName, navigationButton = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = navigateBack
            ), actionButton = listOf(
                IconButton(
                    imageVector = authorFavoriteIcon,
                    tint = authorFavoriteIconColor,
                    onClick = { viewModel.swapAuthorFavorite() },
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

                val songRatingDescription =
                    stringResource(id = R.string.rating_count, song.ratingCount)

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