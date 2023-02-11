package com.beardness.yourchordsru.ui.widgets.toolbar.classic

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable

@Composable
fun AnimatedToolbarWidget(
    title: String,
    visibility: Boolean,
    navigationContent: @Composable (() -> Unit)? = null,
    icons: List<@Composable () -> Unit> = emptyList(),
    onClickToolbar: (() -> Unit)? = null
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(durationMillis = 300))
                + expandVertically(animationSpec = tween(durationMillis = 300)),
        exit = fadeOut(animationSpec = tween(durationMillis = 300))
                + shrinkVertically(animationSpec = tween(durationMillis = 300)),
    ) {
        ToolbarWidget(
            title = title,
            navigationContent = navigationContent,
            icons = icons,
            onClickToolbar = onClickToolbar,
        )
    }
}