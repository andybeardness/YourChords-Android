package com.beardness.yourchordsru.presentation.view.screen.chords

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.view.compose.widget.ChordsWidget
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
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
        ToolbarWidget(
            title = title,
            navigationButton = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = Color.White,
                onClick = navigateBack,
            ),
            actionButton = listOf(),
        )

        ChordsWidget(chords = chords)
    }
}