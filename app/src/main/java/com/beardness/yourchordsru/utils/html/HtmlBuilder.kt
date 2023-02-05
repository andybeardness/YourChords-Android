package com.beardness.yourchordsru.utils.html

import androidx.compose.ui.graphics.Color
import javax.inject.Inject

class HtmlBuilder @Inject constructor(): IHtmlBuilder {
    override fun html(
        content: String,
        backgroundColor: Color,
        textColor: Color,
    ): String {
        val contentFixed = content.fixContent()

        val backgroundRed = (backgroundColor.red * 255).toInt()
        val backgroundGreen = (backgroundColor.green * 255).toInt()
        val backgroundBlue = (backgroundColor.blue * 255).toInt()

        val textRed = (textColor.red * 255).toInt()
        val textGreen = (textColor.green * 255).toInt()
        val textBlue = (textColor.blue * 255).toInt()

        return """<!DOCTYPE html>
    <html lang="en">
    <head>
      <title></title>
    </head>
    <body>
        <style type="text/css" scoped>
            * {
                margin: 0;
                padding: 0;
            }
            
            body {
                background-color: rgb($backgroundRed $backgroundGreen $backgroundBlue);
                width: auto;
            }
            
            pre {
                color: rgb($textRed $textGreen $textBlue);
                font-family: monospace;
                line-height: 1.4;
                font-size: 12px;
                font-weight: 100;
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
}