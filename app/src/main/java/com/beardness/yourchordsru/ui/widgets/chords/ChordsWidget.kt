package com.beardness.yourchordsru.ui.widgets.chords

import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ChordsWidget(
    chords: String,
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
            }
        },
        update = { webView ->
            webView.loadData(chords, "text/html", "UTF-8")
        }
    )
}

@Composable
@Preview
fun Preview_ChordsWidget_0() {
    ChordsWidget(
        chords = ""
    )
}