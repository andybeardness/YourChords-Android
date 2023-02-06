package com.beardness.yourchordsru.ui.widgets.toolbar

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable

@Composable
fun AnimatedSearchFieldWidget(
    visibility: Boolean,
    onClickSearch: (String) -> Unit,
    isSearch: Boolean,
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(durationMillis = 500))
                + expandVertically(animationSpec = tween(durationMillis = 500)),
        exit = fadeOut(animationSpec = tween(durationMillis = 500))
                + shrinkVertically(animationSpec = tween(durationMillis = 500)),
    ) {
        SearchToolbarWidget(
            onClickSearch = onClickSearch,
            isSearch = isSearch
        )
    }
}