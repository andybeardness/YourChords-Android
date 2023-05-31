package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun ToolbarCollapsableWidget(
    title: String,
    navigation: IconButton,
    actions: List<IconButton>,
) {

    var isExpanded by remember { mutableStateOf(value = false) }

    val expandIcon = if (isExpanded) {
        Icons.Rounded.ExpandLess
    } else {
        Icons.Rounded.ExpandMore
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
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

            Text(
                modifier = Modifier
                    .weight(weight = 1f),
                text = title,
                color = Color.White,
            )

            ButtonComponent(
                imageVector = expandIcon,
                tint = Color.White,
                onClick = { isExpanded = !isExpanded },
            )
        }

        if (isExpanded) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = YourChordsRuTheme.dimens.dp64),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                actions.forEach { action ->
                    ButtonComponent(
                        imageVector = action.imageVector,
                        tint = action.tint,
                        onClick = action.onClick,
                    )
                }
            }
        }
    }
}