package com.beardness.yourchordsru.presentation.screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.composeColor

@Composable
fun AboutScreen(
    viewModel: AboutScreenViewModel,
) {
    val themeCode by viewModel.themeCode.collectAsState(initial = null)
    val backgroundColor by viewModel.backgroundColor.collectAsState(initial = null)
    val textColor by viewModel.textColor.collectAsState(initial = null)
    val chordsColor by viewModel.chordsColor.collectAsState(initial = null)
    val fontSize by viewModel.fontSize.collectAsState(initial = null)
    val songSortTypeCode by viewModel.songSortTypeCode.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "themeCode", fontSize = 20.sp, color = YourChordsRuTheme.colors.text)
            Text(text = themeCode.toString(), color = YourChordsRuTheme.colors.text)
        }

        Spacer(modifier = Modifier.height(height = 20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "backgroundColor", fontSize = 20.sp, color = YourChordsRuTheme.colors.text)
            Spacer(
                modifier = Modifier
                    .size(size = 20.dp)
                    .background(color = (backgroundColor ?: 0L).composeColor())
                    .border(width = 2.dp, color = YourChordsRuTheme.colors.text.copy(alpha = 0.2f)),
            )
        }

        Spacer(modifier = Modifier.height(height = 20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "textColor", fontSize = 20.sp, color = YourChordsRuTheme.colors.text)
            Spacer(
                modifier = Modifier
                    .size(size = 20.dp)
                    .background(color = (textColor ?: 0L).composeColor())
                    .border(width = 2.dp, color = YourChordsRuTheme.colors.text.copy(alpha = 0.2f)),
            )
        }

        Spacer(modifier = Modifier.height(height = 20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "chordsColor", fontSize = 20.sp, color = YourChordsRuTheme.colors.text)
            Spacer(
                modifier = Modifier
                    .size(size = 20.dp)
                    .background(color = (chordsColor ?: 0L).composeColor())
                    .border(width = 2.dp, color = YourChordsRuTheme.colors.text.copy(alpha = 0.2f)),
            )
        }

        Spacer(modifier = Modifier.height(height = 20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "fontSize", fontSize = 20.sp, color = YourChordsRuTheme.colors.text)
            Text(text = fontSize.toString(), color = YourChordsRuTheme.colors.text)
        }

        Spacer(modifier = Modifier.height(height = 20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "songSortTypeCode", fontSize = 20.sp, color = YourChordsRuTheme.colors.text)
            Text(text = songSortTypeCode.toString(), color = YourChordsRuTheme.colors.text)
        }
    }
}