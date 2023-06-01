package com.beardness.yourchordsru.presentation.view.screen.chords

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun ChordsScreen(
    viewModel: ChordsScreenViewModelProtocol,
    navigateBack: () -> Unit,
) {

    val title by viewModel.songTitle.collectAsState(initial = "")
    val chords by viewModel.chords.collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    tint = MaterialTheme.colorScheme.onBackground,
                    onClick = { viewModel.increaseText() },
                ),
                IconButton(
                    imageVector = Icons.Rounded.TextDecrease,
                    tint = MaterialTheme.colorScheme.onBackground,
                    onClick = { viewModel.decreaseText() },
                ),
                IconButton(
                    imageVector = Icons.Rounded.LightMode,
                    tint = MaterialTheme.colorScheme.onBackground,
                    onClick = { viewModel.swapViewMode() },
                ),
            ),
        )

        ChordsWidget(chords = chords)
    }
}