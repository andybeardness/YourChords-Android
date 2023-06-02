package com.beardness.yourchordsru.helpers.viewmode

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*
import org.junit.Test

@RunWith(JUnit4::class)
class ViewModeHelperTest {

    private val viewModeHelper: ViewModeHelperProtocol = ViewModeHelper()

    @Test
    fun `viewModeCodeOrDefault() basic`() {
        val actual = viewModeHelper.viewModeCodeOrDefault(
            current = 0,
            size = 10,
            default = 5,
        )

        val expected = 0

        assertEquals(expected, actual)
    }

    @Test
    fun `viewModeCodeOrDefault() null`() {
        val actual = viewModeHelper.viewModeCodeOrDefault(
            current = null,
            size = 10,
            default = 5,
        )

        val expected = 5

        assertEquals(expected, actual)
    }


    @Test
    fun `viewModeCodeOrDefault() out`() {
        val actual = viewModeHelper.viewModeCodeOrDefault(
            current = 20,
            size = 10,
            default = 5,
        )

        val expected = 5

        assertEquals(expected, actual)
    }
}