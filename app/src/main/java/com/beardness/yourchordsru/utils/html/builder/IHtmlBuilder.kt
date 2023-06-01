package com.beardness.yourchordsru.utils.html.builder

import androidx.compose.ui.graphics.Color

interface IHtmlBuilder {
    fun html(
        content: String,
        backgroundColor: Color,
        textColor: Color,
        chordsColor: Color,
        textSizePx: Int,
    ): String
}