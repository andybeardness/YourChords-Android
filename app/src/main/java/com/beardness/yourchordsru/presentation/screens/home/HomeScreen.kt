package com.beardness.yourchordsru.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.beardness.yourchordsru.presentation.screens.dto.types.AuthorsSortType
import com.beardness.yourchordsru.presentation.screens.home.scaffold.HomeScreenScaffold
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.author.AuthorCollectionWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.AnimatedToolbarWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget
import com.beardness.yourchordsru.utils.extensions.clickableHaptic
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: IHomeScreenViewModel,
) {
    val authorsSortType by viewModel
        .authorsSortType
        .collectAsState()

    val authors by viewModel
        .authors
        .collectAsState(initial = emptyList())

    val scrollUp by viewModel
        .scrollUp
        .collectAsState()

    val coroutineScope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()

    val openDrawer = {
        coroutineScope.launch {
            scaffoldState.drawerState.open()
        }
    }

    val toolbarVisibility =
        scrollUp ?: true

    val lazyListState = rememberLazyListState()

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                viewModel.updateScrollPosition(firstVisibleItemIndex = lazyListState.firstVisibleItemIndex)
                return super.onPreScroll(available, source)
            }
        }
    }

    HomeScreenScaffold(
        onClickNavigateHome = { viewModel.navigateToHome() },
        onClickNavigateSettings = { viewModel.navigateToSettings() },
        scaffoldState = scaffoldState,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
        ) {
            AnimatedToolbarWidget(
                title = "Home",
                visibility = toolbarVisibility,
                navigationContent = {
                    Icon(
                        modifier = Modifier
                            .padding(all = YourChordsRuTheme.dimens.dp8)
                            .clip(shape = RoundedCornerShape(percent = 50))
                            .clickableHaptic { openDrawer() }
                            .padding(all = YourChordsRuTheme.dimens.dp8)
                            .size(size = YourChordsRuTheme.dimens.dp32),
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "",
                        tint = YourChordsRuTheme.colors.text,
                    )
                },
                icons = listOf {
                    when (authorsSortType) {
                        AuthorsSortType.DEFAULT -> {
                            ToolbarIconWidget(
                                icon = Icons.Rounded.StarBorder,
                                iconDescription = "",
                                iconColor = YourChordsRuTheme.colors.text,
                                onClick = { viewModel.changeAuthorsSortType() },
                            )
                        }
                        AuthorsSortType.FAVORITE_FIRST -> {
                            ToolbarIconWidget(
                                icon = Icons.Rounded.Star,
                                iconDescription = "",
                                iconColor = YourChordsRuTheme.colors.yellow,
                                onClick = { viewModel.changeAuthorsSortType() },
                            )
                        }
                    }

                    ToolbarIconWidget(
                        icon = Icons.Rounded.Search,
                        iconDescription = "",
                        iconColor = YourChordsRuTheme.colors.text,
                        onClick = { viewModel.navigateToSearch() },
                    )
                }
            )

            AuthorCollectionWidget(
                modifier = Modifier
                    .weight(weight = 1f)
                    .nestedScroll(connection = nestedScrollConnection),
                lazyListState = lazyListState,
                authors = authors,
                onCLick = { authorId -> viewModel.navigateToAuthor(authorId = authorId) },
            )
        }
    }
}