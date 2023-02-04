package com.beardness.yourchordsru.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SongWidget(
    songViewDto: SongViewDto,
    onClick: (authorId: Int, songId: Int) -> Unit,
) {
    val authorId = songViewDto.authorId
    val songId = songViewDto.id

    Text(
        modifier = Modifier.clickable { onClick(authorId, songId) },
        text = songViewDto.title,
        color = YourChordsRuTheme.colors.yellow,
    )
}