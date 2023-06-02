package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchToolbarWidget(
    navigation: IconButton,
    action: IconButton,
    input: String,
    onValueChange: (input: String) -> Unit,
    onClickSearch: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = AppTheme.dimens.dp64),
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
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(percent = 50))
                        .clickable { onValueChange("") },
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(percent = 50),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = AppTheme.colors.transparent,
                errorIndicatorColor = AppTheme.colors.transparent,
                disabledIndicatorColor = AppTheme.colors.transparent,
                unfocusedIndicatorColor = AppTheme.colors.transparent,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                errorContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onClickSearch()
                    keyboardController?.hide()
                }
            ),
            placeholder = {
                Text(
                    text = "Input your search",
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = .5f),
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            textStyle = MaterialTheme.typography.bodyMedium,
        )

        ButtonComponent(
            imageVector = action.imageVector,
            tint = action.tint,
            onClick = action.onClick,
        )
    }
}