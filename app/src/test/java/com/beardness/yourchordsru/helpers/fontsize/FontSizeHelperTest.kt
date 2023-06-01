package com.beardness.yourchordsru.helpers.fontsize

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*

@RunWith(JUnit4::class)
class FontSizeHelperTest {

    private val fontSizeHelper: FontSizeHelperProtocol = FontSizeHelper()

    @Test
    fun `fontSizeOrDefault() basic`() {
        val actual = fontSizeHelper.fontSizeOrDefault(
            fontSize = 14,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 14

        assertEquals(expected, actual)
    }

    @Test
    fun `fontSizeOrDefault() null`() {
        val actual = fontSizeHelper.fontSizeOrDefault(
            fontSize = null,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 12

        assertEquals(expected, actual)
    }

    @Test
    fun `fontSizeOrDefault() out max`() {
        val actual = fontSizeHelper.fontSizeOrDefault(
            fontSize = 50,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 20

        assertEquals(expected, actual)
    }

    @Test
    fun `fontSizeOrDefault() out min`() {
        val actual = fontSizeHelper.fontSizeOrDefault(
            fontSize = 5,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 10

        assertEquals(expected, actual)
    }

    @Test
    fun `fontSizeOrDefault() null & default out max`() {
        val actual = fontSizeHelper.fontSizeOrDefault(
            fontSize = null,
            max = 20,
            min = 10,
            default = 24,
        )

        val expected = 20

        assertEquals(expected, actual)
    }

    @Test
    fun `fontSizeOrDefault() null & default out min`() {
        val actual = fontSizeHelper.fontSizeOrDefault(
            fontSize = null,
            max = 20,
            min = 10,
            default = 4,
        )

        val expected = 10

        assertEquals(expected, actual)
    }

    @Test
    fun `increase() basic`() {
        val actual = fontSizeHelper.increase(
            fontSize = 14,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 16

        assertEquals(expected, actual)
    }

    @Test
    fun `increase() null`() {
        val actual = fontSizeHelper.increase(
            fontSize = null,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 14

        assertEquals(expected, actual)
    }

    @Test
    fun `increase() out max`() {
        val actual = fontSizeHelper.increase(
            fontSize = 50,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 20

        assertEquals(expected, actual)
    }

    @Test
    fun `increase() out min`() {
        val actual = fontSizeHelper.increase(
            fontSize = 5,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 10

        assertEquals(expected, actual)
    }

    @Test
    fun `decrease() basic`() {
        val actual = fontSizeHelper.decrease(
            fontSize = 14,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 12

        assertEquals(expected, actual)
    }

    @Test
    fun `decrease() null`() {
        val actual = fontSizeHelper.decrease(
            fontSize = null,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 10

        assertEquals(expected, actual)
    }

    @Test
    fun `decrease() out max`() {
        val actual = fontSizeHelper.decrease(
            fontSize = 50,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 20

        assertEquals(expected, actual)
    }

    @Test
    fun `decrease() out min`() {
        val actual = fontSizeHelper.decrease(
            fontSize = 5,
            step = 2,
            max = 20,
            min = 10,
            default = 12,
        )

        val expected = 10

        assertEquals(expected, actual)
    }
}