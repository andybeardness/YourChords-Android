package com.beardness.yourchordsru.utils.html

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.utils.extensions.fontSizePxHtmlStyle
import com.beardness.yourchordsru.utils.extensions.htmlStyle
import javax.inject.Inject

class HtmlBuilder @Inject constructor() : IHtmlBuilder {
    override fun html(
        content: String,
        backgroundColor: Color,
        textColor: Color,
        chordsColor: Color,
        textSizePx: Int,
    ): String {
        val contentFixed = content.fixContent()

        return """<!DOCTYPE html>
    <html lang="en">
    <head>
      
    </head>
    <body>
        <style type="text/css" scoped>
            @font-face {
                font-family: ScpNormal;
                src: url('file:///android_asset/fonts/scp_regular.ttf');
                font-weight: normal
            }
            
            @font-face {
                font-family: ScpBold;
                src: url('file:///android_asset/fonts/scp_regular.ttf');
                font-weight: bold
            }
            
            * {
                margin: 0;
                padding: 0;
            }
            
            body {
                background-color: ${backgroundColor.htmlStyle};
                width: auto;
                padding: 10px;
            }
            
            pre {
                font-family: ScpNormal;
                white-space: pre-wrap;
                color: ${textColor.htmlStyle};
                font-family: monospace;
                line-height: 1.5;
                font-size: ${textSizePx.fontSizePxHtmlStyle};
            }
            
            b {
                font-family: ScpBold;
                color: ${chordsColor.htmlStyle};
            }
        </style>
        <pre>
$contentFixed
        </pre>
    </body>
    </html>""".trimIndent()
    }

    private fun String.fixContent(): String =
        this.trim()
            .replace(oldValue = "%", newValue = "%25")
            .replace(oldValue = "#", newValue = "%23")
            .replace(oldValue = "\\n", newValue = "\n")
}