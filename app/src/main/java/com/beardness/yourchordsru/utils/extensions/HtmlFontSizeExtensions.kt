package com.beardness.yourchordsru.utils.extensions

import com.beardness.yourchordsru.config.ChordsConfig

val Int.fontSizePxHtmlStyle: String
    get() = "${this}px"

fun Int.bounds(
    max: Int = ChordsConfig.MAX_FONT_SIZE_PX,
    min: Int = ChordsConfig.MIN_FONT_SIZE_PX,
): Int =
    when {
        this >= max -> max
        this <= min -> min
        else -> this
    }