package com.beardness.yourchordsru.ui.widgets.chords

import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun ChordsWidget(
    chords: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = YourChordsRuTheme.colors.background)
            .verticalScroll(state = rememberScrollState())
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

@Composable
@Preview
fun Preview_ChordsWidget_0() {
    ChordsWidget(
        chords = ""
    )
}