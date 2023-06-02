package com.beardness.yourchordsru.helpers.colors.hash

import androidx.compose.ui.graphics.Color

object ColorHashHelper {

    fun randomColorByHash(text: String, colors: List<Color>, default: Color): Color {
        val hash = text.hashCode()

        val colorsCount = colors.size

        if (colorsCount == 0)
            return default

        if (colorsCount == 1)
            return colors.first()

        val index = hash % colorsCount

        return colors.getOrNull(index = index) ?: default
    }
}