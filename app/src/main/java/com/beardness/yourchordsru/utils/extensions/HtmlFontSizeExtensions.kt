package com.beardness.yourchordsru.utils.extensions

val Int.fontSizePxHtmlStyle: String
    get() = "${this}px"

fun Int.bounds(max: Int, min: Int): Int =
    when {
        this >= max -> max
        this <= min -> min
        else -> this
    }