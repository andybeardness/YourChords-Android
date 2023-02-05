package com.beardness.yourchordsru.ui.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Immutable
data class AppTypography(
    val authorNameAtAuthorCard: TextStyle,
    val songNameAtSongCard: TextStyle,
    val chordsAtSongCard: TextStyle,
    val ratingAtSongCard: TextStyle,
    val navigationAtDrawer: TextStyle,
    val titleAtToolbar: TextStyle,
)

val typography = AppTypography(
    authorNameAtAuthorCard = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
    ),
    songNameAtSongCard = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
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
        fontSize = 22.sp,
        fontWeight = FontWeight.Light,
    )
)

val LocalExtendedTypography = staticCompositionLocalOf {
    AppTypography(
        authorNameAtAuthorCard = typography.authorNameAtAuthorCard,
        songNameAtSongCard = typography.songNameAtSongCard,
        chordsAtSongCard = typography.chordsAtSongCard,
        ratingAtSongCard = typography.ratingAtSongCard,
        navigationAtDrawer = typography.navigationAtDrawer,
        titleAtToolbar = typography.titleAtToolbar,
    )
}