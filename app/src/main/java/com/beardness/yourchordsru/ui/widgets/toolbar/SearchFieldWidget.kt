package com.beardness.yourchordsru.ui.widgets.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SearchFieldWidget(
    modifier: Modifier,
    input: String,
    onUpdate: (update: String) -> Unit,
    onClickSearch: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                color = YourChordsRuTheme.colors.background,
                shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp32)
            )
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
        contentAlignment = Alignment.Center,
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = input,
            onValueChange = onUpdate,
            singleLine = true,
            textStyle = YourChordsRuTheme.typography.patternAtSearch
                .copy(color = YourChordsRuTheme.colors.text),
            cursorBrush = SolidColor(value = YourChordsRuTheme.colors.text),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onClickSearch() }),
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart,
                ) {
                    if (input.isEmpty()) {
                        Text(
                            text = "Search...",
                            color = YourChordsRuTheme.colors.text.copy(alpha = .2f),
                            style = YourChordsRuTheme.typography.placeholderAtSearch,
                        )
                    }

                    innerTextField()
                }
            }
        )
    }
}