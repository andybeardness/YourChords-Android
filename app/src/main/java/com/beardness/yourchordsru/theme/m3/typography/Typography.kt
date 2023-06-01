package com.beardness.yourchordsru.theme.m3.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Immutable
data class AppTypography(
    val authorNameAtAuthorCard: TextStyle,
    val songTitleAtSongCard: TextStyle,
    val authorNameAtSongCard: TextStyle,
    val chordsAtSongCard: TextStyle,
    val ratingAtSongCard: TextStyle,
    val navigationAtDrawer: TextStyle,
    val titleAtToolbar: TextStyle,
    val patternAtSearch: TextStyle,
    val placeholderAtSearch: TextStyle,
    val tagTitleAtSearchToolbar: TextStyle,
    val titleAtSettings: TextStyle,
    val themeTitleAtSettings: TextStyle,
    val fontSizeTitleAtFontSizeSetting: TextStyle,
    val charAtSlider: TextStyle,
    val titleAtSongScreenToolbar: TextStyle,
)

val typography = AppTypography(
    authorNameAtAuthorCard = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
    ),
    songTitleAtSongCard = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
    ),
    authorNameAtSongCard = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraLight,
    ),
    chordsAtSongCard = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.ExtraLight,
    ),
    ratingAtSongCard = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.ExtraLight,
        textAlign = TextAlign.Center,
    ),
    navigationAtDrawer = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
    ),
    titleAtToolbar = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
    ),
    patternAtSearch = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
    ),
    placeholderAtSearch = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraLight,
    ),
    tagTitleAtSearchToolbar = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
    ),
    titleAtSettings = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Light,
    ),
    themeTitleAtSettings = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraLight,
    ),
    fontSizeTitleAtFontSizeSetting = TextStyle(
        fontWeight = FontWeight.Light,
    ),
    charAtSlider = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Light,
    ),
    titleAtSongScreenToolbar = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.ExtraLight,
    ),
)

val LocalExtendedTypography = staticCompositionLocalOf {
    AppTypography(
        authorNameAtAuthorCard = typography.authorNameAtAuthorCard,
        songTitleAtSongCard = typography.songTitleAtSongCard,
        authorNameAtSongCard = typography.authorNameAtSongCard,
        chordsAtSongCard = typography.chordsAtSongCard,
        ratingAtSongCard = typography.ratingAtSongCard,
        navigationAtDrawer = typography.navigationAtDrawer,
        titleAtToolbar = typography.titleAtToolbar,
        patternAtSearch = typography.patternAtSearch,
        placeholderAtSearch = typography.placeholderAtSearch,
        tagTitleAtSearchToolbar = typography.tagTitleAtSearchToolbar,
        titleAtSettings = typography.titleAtSettings,
        themeTitleAtSettings = typography.themeTitleAtSettings,
        fontSizeTitleAtFontSizeSetting = typography.fontSizeTitleAtFontSizeSetting,
        charAtSlider = typography.charAtSlider,
        titleAtSongScreenToolbar = typography.titleAtSongScreenToolbar,
    )
}