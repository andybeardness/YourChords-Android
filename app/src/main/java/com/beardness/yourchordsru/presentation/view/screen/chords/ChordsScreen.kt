package com.beardness.yourchordsru.presentation.view.screen.chords

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.TextDecrease
import androidx.compose.material.icons.rounded.TextIncrease
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.view.compose.widget.ChordsWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarCollapsableWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun ChordsScreen(
    viewModel: ChordsScreenViewModelProtocol,
    navigateBack: () -> Unit,
) {
    val viewMode by viewModel.viewMode.collectAsState(initial = ChordsViewMode.LIGHT_BLUE)
    val title by viewModel.songTitle.collectAsState(initial = "")
    val chords by viewModel.chords.collectAsState(initial = "")

    val isMaxFontSize by viewModel.isMaxFontSize.collectAsState(initial = false)
    val isMinFontSize by viewModel.isMinFontSize.collectAsState(initial = false)

    val viewModeButtonColor by animateColorAsState(
        targetValue = when (viewMode) {
            ChordsViewMode.LIGHT_BLUE -> AppTheme.colors.blue
            ChordsViewMode.LIGHT_CORAL -> AppTheme.colors.coral
            ChordsViewMode.DARK_ORANGE -> AppTheme.colors.orange
            ChordsViewMode.DARK_GREEN -> AppTheme.colors.green
            ChordsViewMode.SEPIA -> MaterialTheme.colorScheme.onBackground
        },
        animationSpec = tween(durationMillis = 250),
    )

    val textIncreaseButtonColor by animateColorAsState(
        targetValue = if (isMaxFontSize) {
            MaterialTheme.colorScheme.onBackground.copy(alpha = .3f)
        } else {
            MaterialTheme.colorScheme.onBackground
        },
        animationSpec = tween(durationMillis = 250)
    )

    val textDecreaseButtonColor by animateColorAsState(
        targetValue = if (isMinFontSize) {
            MaterialTheme.colorScheme.onBackground.copy(alpha = .3f)
        } else {
            MaterialTheme.colorScheme.onBackground
        },
        animationSpec = tween(durationMillis = 250)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        ToolbarCollapsableWidget(
            title = title,
            navigation = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = navigateBack,
            ),
            actions = listOf(
                IconButton(
                    imageVector = Icons.Rounded.TextIncrease,
                    tint = textIncreaseButtonColor,
                    onClick = { viewModel.increaseText() },
                ),
                IconButton(
                    imageVector = Icons.Rounded.TextDecrease,
                    tint = textDecreaseButtonColor,
                    onClick = { viewModel.decreaseText() },
                ),
                IconButton(
                    imageVector = Icons.Rounded.LightMode,
                    tint = viewModeButtonColor,
                    onClick = { viewModel.swapViewMode() },
                ),
            ),
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight = 1f)
        ) {
            ChordsWidget(
                modifier = Modifier
                    .fillMaxSize(),
                chords = chords,
            )
        }
    }
}