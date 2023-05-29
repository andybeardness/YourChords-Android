package com.beardness.yourchordsru.presentation.view.dto

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

class ToolbarButtonViewDto(
    val imageVector: ImageVector,
    val tint: Color,
    val onClick: (() -> Unit)?,
)