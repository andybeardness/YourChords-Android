package com.beardness.yourchordsru.presentation.screens.author

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.SortByAlpha
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.navigation.ArrowBackWidget
import com.beardness.yourchordsru.ui.widgets.song.SongCollectionWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.AnimatedToolbarWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget
import com.beardness.yourchordsru.utils.sorttype.SongsSortType

@Composable
fun AuthorScreen(
    viewModel: IAuthorScreenViewModel,
) {
    val authorName by viewModel.authorName.collectAsState()
    val songs by viewModel.songs.collectAsState()
    val sortType by viewModel.songsSortType.collectAsState(initial = SongsSortType.BY_NAME)
    val scrollUp by viewModel.scrollUp.collectAsState()

    val lazyListState = rememberLazyListState()

    val nestedScrollConnection =
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                viewModel.updateScrollPosition(firstVisibleItemIndex = lazyListState.firstVisibleItemIndex)
                return super.onPreScroll(available, source)
            }
        }

    val toolbarVisibility = scrollUp ?: true

    val songsSortTypeIcon =
        when (sortType) {
            SongsSortType.BY_NAME -> Icons.Rounded.SortByAlpha
            SongsSortType.BY_RATING -> Icons.Rounded.TrendingUp
        }

    val songsSortTypeIconColor =
        when (sortType) {
            SongsSortType.BY_NAME -> YourChordsRuTheme.colors.blue
            SongsSortType.BY_RATING -> YourChordsRuTheme.colors.red
        }

    Column {
        AnimatedToolbarWidget(
            title = authorName,
            visibility = toolbarVisibility,
            navigationContent = {
                ArrowBackWidget(
                    onClick = { viewModel.navigateBack() }
                )
            },
            icons = listOf {
                ToolbarIconWidget(
                    icon = songsSortTypeIcon,
                    iconDescription = "",
                    iconColor = songsSortTypeIconColor,
                    onClick = { viewModel.switchSortType() },
                )

                ToolbarIconWidget(
                    icon = Icons.Rounded.Search,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text,
                    onClick = { viewModel.navigateToSearch() },
                )
            }
        )

        SongCollectionWidget(
            modifier = Modifier
                .weight(weight = 1f)
                .nestedScroll(connection = nestedScrollConnection),
            lazyListState = lazyListState,
            songs = songs,
            onCLick = { authorId, songId ->
                viewModel.navigateToSong(
                    authorId = authorId,
                    songId = songId
                )
            },
            onClickMakeFavorite = { authorId, songId ->
                viewModel.makeFavorite(
                    authorId = authorId,
                    songId = songId
                )
            },
            onClickRemoveFavorite = { authorId, songId ->
                viewModel.removeFavorite(
                    authorId = authorId,
                    songId = songId
                )
            }
        )
    }
}