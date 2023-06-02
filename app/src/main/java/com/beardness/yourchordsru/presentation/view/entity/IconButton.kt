package com.beardness.yourchordsru.presentation.view.entity

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class IconButton(
    val imageVector: ImageVector,
    val tint: Color,
    val onClick: (() -> Unit)?,
)