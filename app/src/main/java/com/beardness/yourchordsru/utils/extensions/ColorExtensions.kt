package com.beardness.yourchordsru.utils.extensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.beardness.yourchordsru.helpers.colors.ColorHashHelper
import com.beardness.yourchordsru.theme.AppTheme

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

@Composable
fun randomColor(input: String): Color {
    val colors = listOf(
        AppTheme.colors.blue,
        AppTheme.colors.purple,
        AppTheme.colors.coral,
        AppTheme.colors.orange,
    )

    return ColorHashHelper
        .randomColorByHash(
            text = input,
            colors = colors,
            default = colors.first(),
        )
}

@Composable
fun randomColor(input: String, colors: List<Color>, default: Color): Color =
    ColorHashHelper.randomColorByHash(
        text = input,
        colors = colors,
        default = default,
    )

@Composable
fun randomContainerColorM3(input: String): Color =
    ColorHashHelper.randomColorByHash(
        text = input,
        colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.tertiary,
        ),
        default = MaterialTheme.colorScheme.primary,
    )

@Composable
fun randomOnContainerColorM3(input: String): Color =
    ColorHashHelper.randomColorByHash(
        text = input,
        colors = listOf(
            MaterialTheme.colorScheme.onPrimary,
            MaterialTheme.colorScheme.onSecondary,
            MaterialTheme.colorScheme.onTertiary,
        ),
        default = MaterialTheme.colorScheme.onPrimary,
    )