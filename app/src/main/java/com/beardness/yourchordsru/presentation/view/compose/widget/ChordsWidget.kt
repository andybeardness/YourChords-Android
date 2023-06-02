package com.beardness.yourchordsru.presentation.view.compose.widget

import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ChordsWidget(
    modifier: Modifier,
    chords: String,
) {
    Column(
        modifier = modifier
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
}