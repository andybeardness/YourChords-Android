package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.widgets.chords.ChordsWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.chords.ChordsToolbarWidget

@Composable
fun SongScreen(
    viewModel: ISongScreenViewModel,
) {
    val songTitle by viewModel.songTitle.collectAsState()
    val chords by viewModel.chords.collectAsState()
    val isToolbarExpanded by viewModel.isToolbarExpanded.collectAsState()
    val textSize by viewModel.textSize.collectAsState()

    val isIncreaseButtonActive = textSize != SongScreenViewModel.MAX_FONT_SIZE_PX
    val isResetButtonActive = textSize != SongScreenViewModel.DEFAULT_FONT_SIZE_PX
    val isDecreaseButtonActive = textSize != SongScreenViewModel.MIN_FONT_SIZE_PX

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ChordsToolbarWidget(
            title = songTitle,
            onClickNavigation = { viewModel.navigateBack() },
            isExpanded = isToolbarExpanded,
            onClickExpand = { viewModel.expandToolbar() },
            onClickTextIncrease = { viewModel.textIncrease() },
            isIncreaseButtonActive = isIncreaseButtonActive,
            onClickResetFontSize = { viewModel.textReset() },
            isResetFontSizeButtonActive = isResetButtonActive,
            onClickTextDecrease = { viewModel.textDecrease() },
            isDecreaseButtonActive = isDecreaseButtonActive,
            onClickChords = { viewModel.navigateChords() }
        )

        ChordsWidget(
            chords = chords,
        )
    }
}