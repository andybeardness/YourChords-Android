package com.beardness.yourchordsru.utils.html

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