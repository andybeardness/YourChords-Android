package com.beardness.yourchordsru.theme.app.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppDimens(
    val dp0: Dp,
    val dp1: Dp,
    val dp2: Dp,
    val dp4: Dp,
    val dp8: Dp,
    val dp12: Dp,
    val dp16: Dp,
    val dp32: Dp,
    val dp48: Dp,
    val dp64: Dp,
    val dp80: Dp,
    val dp64x2: Dp,
    val dp64x3: Dp,
    val dp64x4: Dp,
    val dp64x5: Dp,
    val bottomBannerHeight: Dp,
)

val appDimens = AppDimens(
    dp0 = 0.dp,
    dp1 = 1.dp,
    dp2 = 2.dp,
    dp4 = 4.dp,
    dp8 = 8.dp,
    dp12 = 12.dp,
    dp16 = 16.dp,
    dp32 = 32.dp,
    dp48 = 48.dp,
    dp64 = 64.dp,
    dp80 = 80.dp,
    dp64x2 = 128.dp,
    dp64x3 = 192.dp,
    dp64x4 = 256.dp,
    dp64x5 = 320.dp,
    bottomBannerHeight = 50.dp,
)

val LocalExtendedDimens = staticCompositionLocalOf {
    AppDimens(
        dp0 = appDimens.dp0,
        dp1 = appDimens.dp1,
        dp2 = appDimens.dp2,
        dp4 = appDimens.dp4,
        dp8 = appDimens.dp8,
        dp12 = appDimens.dp12,
        dp16 = appDimens.dp16,
        dp32 = appDimens.dp32,
        dp48 = appDimens.dp48,
        dp64 = appDimens.dp64,
        dp80 = appDimens.dp80,
        dp64x2 = appDimens.dp64x2,
        dp64x3 = appDimens.dp64x3,
        dp64x4 = appDimens.dp64x4,
        dp64x5 = appDimens.dp64x5,
        bottomBannerHeight = appDimens.bottomBannerHeight,
    )
}