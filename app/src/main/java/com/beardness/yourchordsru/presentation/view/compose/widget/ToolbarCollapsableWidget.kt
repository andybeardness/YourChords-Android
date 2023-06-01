package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun ToolbarCollapsableWidget(
    title: String,
    navigation: IconButton,
    actions: List<IconButton>,
) {
    var isExpanded by remember { mutableStateOf(value = false) }

    val toolbarHeight by animateDpAsState(
        targetValue = if (isExpanded) AppTheme.dimens.dp64x2 else AppTheme.dimens.dp64,
        animationSpec = tween(durationMillis = 250),
    )

    val expandIconRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(durationMillis = 250),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = toolbarHeight)
    ) {
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

            Text(
                modifier = Modifier
                    .weight(weight = 1f),
                text = title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            ButtonComponent(
                imageVector = Icons.Rounded.ExpandMore,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = { isExpanded = !isExpanded },
                rotation = expandIconRotation
            )
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = slideInVertically(animationSpec = tween(durationMillis = 250))
                    + fadeIn(animationSpec = tween(durationMillis = 250)),
            exit = slideOutVertically(animationSpec = tween(durationMillis = 250))
                    + fadeOut(animationSpec = tween(durationMillis = 250)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = AppTheme.dimens.dp64),
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