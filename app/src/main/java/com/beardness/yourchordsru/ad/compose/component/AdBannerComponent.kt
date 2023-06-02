package com.beardness.yourchordsru.ad.compose.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.viewinterop.AndroidView
import com.beardness.yourchordsru.BuildConfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdBannerComponent() {
    val inspectionMode = LocalInspectionMode.current

    val bannerId = BuildConfig.ADMOB_BOTTOM_BANNER_ID

    if (!inspectionMode) {
        AndroidView(
            modifier = Modifier
                .fillMaxSize(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = bannerId
                    loadAd(AdRequest.Builder().build())
                }
            },
        )
    }
}