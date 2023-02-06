package com.beardness.yourchordsru.presentation.screens.home

import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.author.AuthorCollectionWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.AnimatedToolbarWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.ToolbarIconWidget

@Composable
fun HomeScreen(
    viewModel: IHomeScreenViewModel,
) {
    val authors by viewModel
        .authors
        .collectAsState(initial = emptyList())

    val scrollUp by viewModel
        .scrollUp
        .collectAsState()

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

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AnimatedToolbarWidget(
            title = "Home",
            visibility = toolbarVisibility,
            navigationContent = {
                Icon(
                    modifier = Modifier
                        .padding(all = YourChordsRuTheme.dimens.dp8)
                        .clip(shape = RoundedCornerShape(percent = 50))
                        .clickable { viewModel.openDrawer() }
                        .padding(all = YourChordsRuTheme.dimens.dp8)
                        .size(size = YourChordsRuTheme.dimens.dp32),
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "",
                    tint = YourChordsRuTheme.colors.text,
                )
            },
            icons = listOf {
                ToolbarIconWidget(
                    icon = Icons.Rounded.StarBorder,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text,
                    onClick = {},
                )

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