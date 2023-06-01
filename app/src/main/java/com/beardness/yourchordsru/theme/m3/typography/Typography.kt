package com.beardness.yourchordsru.theme.m3.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.beardness.your_chords_ru.R

private val blackFontFamily = FontFamily(Font(resId = R.font.font_nunito_black))
private val extraBoldFontFamily = FontFamily(Font(resId = R.font.font_nunito_extrabold))
private val boldFontFamily = FontFamily(Font(resId = R.font.font_nunito_bold))
private val semiBoldFontFamily = FontFamily(Font(resId = R.font.font_nunito_semibold))
private val mediumFontFamily = FontFamily(Font(resId = R.font.font_nunito_medium))
private val regularFontFamily = FontFamily(Font(resId = R.font.font_nunito_regular))
private val lightFontFamily = FontFamily(Font(resId = R.font.font_nunito_light))
private val extraLightFontFamily = FontFamily(Font(resId = R.font.font_nunito_extralight))

val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = boldFontFamily,
    ),
    displayMedium = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = boldFontFamily,
    ),
    displaySmall = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = boldFontFamily,
    ),

    headlineLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = semiBoldFontFamily,
    ),
    headlineMedium = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = semiBoldFontFamily,
    ),
    headlineSmall = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = semiBoldFontFamily,
    ),

    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = mediumFontFamily,
    ),
    titleMedium = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = mediumFontFamily,
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = mediumFontFamily,
    ),

    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = regularFontFamily,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = regularFontFamily,
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = regularFontFamily,
    ),

    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = lightFontFamily,
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = lightFontFamily,
    ),
    labelSmall = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = lightFontFamily,
    ),
)