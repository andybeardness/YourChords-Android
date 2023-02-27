package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.config.ChordsConfig
import com.beardness.yourchordsru.ui.widgets.chords.ChordsWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.chords.ChordsToolbarWidget
import com.beardness.yourchordsru.utils.extensions.composeColor

@Composable
fun SongScreen(
    viewModel: ISongScreenViewModel,
) {
    val songTitle by viewModel.songTitle.collectAsState()
    val chords by viewModel.chords.collectAsState(initial = "")
    val isToolbarExpanded by viewModel.isToolbarExpanded.collectAsState()
    val textSize by viewModel.textSize.collectAsState()

    val backgroundColor by viewModel.backgroundColor.collectAsState()
    val textColor by viewModel.textColor.collectAsState()
    val chordsColor by viewModel.chordsColor.collectAsState()

    val backgroundColors = ChordsConfig.BACKGROUND_COLORS.map { color -> color.composeColor() }
    val textColors = ChordsConfig.TEXT_COLORS.map { color -> color.composeColor() }
    val chordsColors = ChordsConfig.CHORDS_COLORS.map { color -> color.composeColor() }

    val isIncreaseButtonActive = textSize != ChordsConfig.MAX_FONT_SIZE_PX
    val isDecreaseButtonActive = textSize != ChordsConfig.MIN_FONT_SIZE_PX

    val backgroundColorsTitle = "Background color"
    val textColorsTitle = "Text color"
    val chordsColorsTitle = "Chords color"

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
            onClickTextDecrease = { viewModel.textDecrease() },
            isDecreaseButtonActive = isDecreaseButtonActive,
            backgroundColorsTitle = backgroundColorsTitle,
            backgroundColors = backgroundColors,
            activeBackgroundColor = backgroundColor,
            onClickBackgroundColor = { color: Color -> viewModel.changeBackgroundColor(color = color) },
            textColorsTitle = textColorsTitle,
            textColors = textColors,
            activeTextColor = textColor,
            onClickTextColor = { color: Color -> viewModel.changeTextColor(color = color) },
            chordsColorsTitle = chordsColorsTitle,
            chordsColors = chordsColors,
            activeChordsColor = chordsColor,
            onClickChordsColor = { color: Color -> viewModel.changeChordsColor(color = color) },
        )

        ChordsWidget(
            chords = chords,
        )
    }
}