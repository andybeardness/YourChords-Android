package com.beardness.yourchordsru.helpers.colors.hash

import androidx.compose.ui.graphics.Color
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*

@RunWith(JUnit4::class)
class ColorHashHelperTest {

    @Test
    fun `randomColorByHash_KingAndJoker`() {
        val text = "Король и шут"
        val colors = listOf(
            Color.Red,
            Color.Green,
            Color.Blue,
        )
        val default = Color.Red

        val actual = ColorHashHelper.randomColorByHash(
            text = text,
            colors = colors,
            default = default,
        )
        val expected = Color.Red

        assertEquals(expected, actual)
    }

    @Test
    fun `randomColorByHash_5nizza`() {
        val text = "5'nizza"
        val colors = listOf(
            Color.Red,
            Color.Green,
            Color.Blue,
        )
        val default = Color.Red

        val actual = ColorHashHelper.randomColorByHash(
            text = text,
            colors = colors,
            default = default,
        )
        val expected = Color.Green

        assertEquals(expected, actual)
    }

    @Test
    fun `randomColorByHash_Splin`() {
        val text = "Сплин"
        val colors = listOf(
            Color.Red,
            Color.Green,
            Color.Blue,
        )
        val default = Color.Red

        val actual = ColorHashHelper.randomColorByHash(
            text = text,
            colors = colors,
            default = default,
        )
        val expected = Color.Green

        assertEquals(expected, actual)
    }

    @Test
    fun `randomColorByHash_Empty_colors`() {
        val text = "RHCP"
        val colors = emptyList<Color>()
        val default = Color.Red

        val actual = ColorHashHelper.randomColorByHash(
            text = text,
            colors = colors,
            default = default,
        )
        val expected = Color.Red

        assertEquals(expected, actual)
    }

    @Test
    fun `randomColorByHash_One_color_in_collection`() {
        val text = "Venya D'rkin"
        val colors = listOf(
            Color.Red
        )
        val default = Color.Red

        val actual = ColorHashHelper.randomColorByHash(
            text = text,
            colors = colors,
            default = default,
        )
        val expected = Color.Red

        assertEquals(expected, actual)
    }

    @Test
    fun `randomColorByHash_One_color_in_collection_and_different_default`() {
        val text = "PALC"
        val colors = listOf(
            Color.Red
        )
        val default = Color.Blue

        val actual = ColorHashHelper.randomColorByHash(
            text = text,
            colors = colors,
            default = default,
        )
        val expected = Color.Red

        assertEquals(expected, actual)
    }
}