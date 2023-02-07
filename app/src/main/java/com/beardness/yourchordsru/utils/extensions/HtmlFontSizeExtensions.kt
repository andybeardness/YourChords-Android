package com.beardness.yourchordsru.utils.extensions

fun Int.bounds(max: Int, min: Int): Int =
    when {
        this >= max -> max
        this <= min -> min
        else -> this
    }