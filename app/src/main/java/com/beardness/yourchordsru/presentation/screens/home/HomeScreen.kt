package com.beardness.yourchordsru.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.author.AuthorCollectionWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.ToolbarIconWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.ToolbarWidget

@Composable
fun HomeScreen(
    viewModel: IHomeScreenViewModel,
) {
    val authors by
        viewModel
            .authors
            .collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = "Home",
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
                    onClick = {},
                )
            }
        )

        AuthorCollectionWidget(
            modifier = Modifier
                .weight(weight = 1f),
            authors = authors,
            onCLick = { authorId -> viewModel.navigateToAuthor(authorId = authorId) },
        )
    }
}