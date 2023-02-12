package com.beardness.yourchordsru.ui.widgets.search

import androidx.compose.runtime.Composable
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.ui.widgets.author.AuthorWidget

@Composable
fun SearchAuthorWidget(
    item: SearchResultAuthor,
    onClick: () -> Unit,
    onClickMakeFavorite: () -> Unit,
    onClickRemoveFavorite: () -> Unit,
) {
    val author = item.viewDto()

    AuthorWidget(
        authorViewDto = author,
        onClickAuthor = onClick,
        actionMakeFavorite = onClickMakeFavorite,
        actionRemoveFavorite = onClickRemoveFavorite,
    )
}