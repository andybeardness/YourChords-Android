package com.beardness.yourchordsru.utils.html.colors

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import com.beardness.yourchordsru.theme.app.colors.appColors
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HtmlColorUtilsTest {

    private val htmlColorUtils: HtmlColorUtilsProtocol = HtmlColorUtils()

    @Test
    fun `choose_Mode_LIGHT_BLUE`() {
        val mode = ChordsViewMode.LIGHT_BLUE
        val htmlColors = htmlColorUtils.choose(mode = mode)

        Assert.assertEquals(
            appColors.white,
            htmlColors.backgroundColor,
        )
        Assert.assertEquals(
            appColors.black,
            htmlColors.textColor,
        )
        Assert.assertEquals(
            appColors.blue,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `choose_Mode_LIGHT_CORAL`() {
        val mode = ChordsViewMode.LIGHT_CORAL
        val htmlColors = htmlColorUtils.choose(mode = mode)

        Assert.assertEquals(
            appColors.white,
            htmlColors.backgroundColor,
        )
        Assert.assertEquals(
            appColors.black,
            htmlColors.textColor,
        )
        Assert.assertEquals(
            appColors.coral,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `choose_Mode_DARK_ORANGE`() {
        val mode = ChordsViewMode.DARK_ORANGE
        val htmlColors = htmlColorUtils.choose(mode = mode)

        Assert.assertEquals(
            appColors.black,
            htmlColors.backgroundColor,
        )
        Assert.assertEquals(
            appColors.white,
            htmlColors.textColor,
        )
        Assert.assertEquals(
            appColors.orange,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `choose_Mode_DARK_GREEN`() {
        val mode = ChordsViewMode.DARK_GREEN
        val htmlColors = htmlColorUtils.choose(mode = mode)

        Assert.assertEquals(
            appColors.black,
            htmlColors.backgroundColor,
        )
        Assert.assertEquals(
            appColors.white,
            htmlColors.textColor,
        )
        Assert.assertEquals(
            appColors.green,
            htmlColors.chordsColor,
        )
    }

    @Test
    fun `choose_Mode_SEPIA`() {
        val mode = ChordsViewMode.SEPIA
        val htmlColors = htmlColorUtils.choose(mode = mode)

        Assert.assertEquals(
            appColors.sepia,
            htmlColors.backgroundColor,
        )
        Assert.assertEquals(
            appColors.black,
            htmlColors.textColor,
        )
        Assert.assertEquals(
            appColors.black,
            htmlColors.chordsColor,
        )
    }
}