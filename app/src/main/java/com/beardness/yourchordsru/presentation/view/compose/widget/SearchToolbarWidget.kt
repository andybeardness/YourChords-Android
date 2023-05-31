package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun SearchToolbarWidget(
    navigation: IconButton,
    action: IconButton,
    input: String,
    onValueChange: (input: String) -> Unit,
    onClickSearch: (pattern: String) -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ButtonComponent(
            imageVector = navigation.imageVector,
            tint = navigation.tint,
            onClick = navigation.onClick,
        )

        TextField(
            modifier = Modifier
                .weight(weight = 1f),
            value = input,
            onValueChange = onValueChange,
        )

        ButtonComponent(
            imageVector = action.imageVector,
            tint = action.tint,
            onClick = action.onClick,
        )
    }
}