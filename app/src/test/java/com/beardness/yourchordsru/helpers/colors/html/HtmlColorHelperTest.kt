package com.beardness.yourchordsru.helpers.colors.html

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import com.beardness.yourchordsru.theme.app.colors.appColors
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*

@RunWith(JUnit4::class)
class HtmlColorHelperTest {

    private val htmlColorHelper: HtmlColorHelperProtocol = HtmlColorHelper()

    @Test
    fun `Mode == LIGHT_BLUE`() {
        val mode = ChordsViewMode.LIGHT_BLUE
        val htmlColors = htmlColorHelper.choose(mode = mode)

        assertEquals(
            appColors.white,
            htmlColors.backgroundColor,
        )
        assertEquals(
            appColors.black,
            htmlColors.textColor,
        )
        assertEquals(
            appColors.blue,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `Mode == LIGHT_CORAL`() {
        val mode = ChordsViewMode.LIGHT_CORAL
        val htmlColors = htmlColorHelper.choose(mode = mode)

        assertEquals(
            appColors.white,
            htmlColors.backgroundColor,
        )
        assertEquals(
            appColors.black,
            htmlColors.textColor,
        )
        assertEquals(
            appColors.coral,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `Mode == DARK_ORANGE`() {
        val mode = ChordsViewMode.DARK_ORANGE
        val htmlColors = htmlColorHelper.choose(mode = mode)

        assertEquals(
            appColors.black,
            htmlColors.backgroundColor,
        )
        assertEquals(
            appColors.white,
            htmlColors.textColor,
        )
        assertEquals(
            appColors.orange,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `Mode == DARK_GREEN`() {
        val mode = ChordsViewMode.DARK_GREEN
        val htmlColors = htmlColorHelper.choose(mode = mode)

        assertEquals(
            appColors.black,
            htmlColors.backgroundColor,
        )
        assertEquals(
            appColors.white,
            htmlColors.textColor,
        )
        assertEquals(
            appColors.green,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `Mode == SEPIA`() {
        val mode = ChordsViewMode.SEPIA
        val htmlColors = htmlColorHelper.choose(mode = mode)

        assertEquals(
            appColors.sepia,
            htmlColors.backgroundColor,
        )
        assertEquals(
            appColors.black,
            htmlColors.textColor,
        )
        assertEquals(
            appColors.black,
            htmlColors.chordsColor,
        )
    }
}