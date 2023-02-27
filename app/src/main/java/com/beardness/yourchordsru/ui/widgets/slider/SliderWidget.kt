package com.beardness.yourchordsru.ui.widgets.slider

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.utils.extensions.toAuthorFirstCharColor

@Composable
fun SliderWidget(
    lazyListState: LazyListState,
    chars: List<Char>,
    onClickChar: (Char) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        state = lazyListState,
    ) {
        items(count = chars.size) { index ->
            val char = chars[index]

            val charColor = char.toAuthorFirstCharColor()

            SliderElementWidget(
                char = char,
                charColor = charColor,
                onClickChar = { onClickChar(char) }
            )
        }
    }
}