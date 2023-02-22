package com.beardness.yourchordsru.utils.extensions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

val Color.htmlStyle: String
    get() = "rgb(${this.r} ${this.g} ${this.b})"

fun Color.buttonColorByCondition(condition: Boolean): Color =
    if (condition) {
        this
    } else {
        this.copy(alpha = .2f)
    }

fun Long.composeColor(): Color {
    return Color(color = this)
}

fun Color.toLong(): Long =
    this.toArgb().toLong()

private val Color.r: Int
    get() = (this.red * 255).toInt()

private val Color.g: Int
    get() = (this.green * 255).toInt()

private val Color.b: Int
    get() = (this.blue * 255).toInt()
