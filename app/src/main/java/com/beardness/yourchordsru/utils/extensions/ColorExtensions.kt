package com.beardness.yourchordsru.utils.extensions

import androidx.compose.ui.graphics.Color

val Color.htmlStyle: String
    get() = "rgb(${this.r} ${this.g} ${this.b})"

fun Color.buttonColorByCondition(condition: Boolean): Color =
    if (condition) {
        this
    } else {
        this.copy(alpha = .2f)
    }

private val Color.r: Int
    get() = (this.red * 255).toInt()

private val Color.g: Int
    get() = (this.green * 255).toInt()

private val Color.b: Int
    get() = (this.blue * 255).toInt()
