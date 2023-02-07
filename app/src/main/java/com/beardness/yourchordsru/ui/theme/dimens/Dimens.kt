package com.beardness.yourchordsru.ui.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppDimens(
    val dp1: Dp,
    val dp2: Dp,
    val dp4: Dp,
    val dp8: Dp,
    val dp16: Dp,
    val dp32: Dp,
    val dp64: Dp,
    val dp64x2: Dp,
    val dp64x3: Dp,
    val dp64x4: Dp,
    val bottomBannerHeight: Dp,
)

val dimens = AppDimens(
    dp1 = 1.dp,
    dp2 = 2.dp,
    dp4 = 4.dp,
    dp8 = 8.dp,
    dp16 = 16.dp,
    dp32 = 32.dp,
    dp64 = 64.dp,
    dp64x2 = 128.dp,
    dp64x3 = 192.dp,
    dp64x4 = 256.dp,
    bottomBannerHeight = 50.dp,
)

val LocalExtendedDimens = staticCompositionLocalOf {
    AppDimens(
        dp1 = dimens.dp1,
        dp2 = dimens.dp2,
        dp4 = dimens.dp4,
        dp8 = dimens.dp8,
        dp16 = dimens.dp16,
        dp32 = dimens.dp32,
        dp64 = dimens.dp64,
        dp64x2 = dimens.dp64x2,
        dp64x3 = dimens.dp64x3,
        dp64x4 = dimens.dp64x4,
        bottomBannerHeight = dimens.bottomBannerHeight,
    )
}