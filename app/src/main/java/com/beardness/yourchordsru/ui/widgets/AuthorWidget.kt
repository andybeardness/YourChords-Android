package com.beardness.yourchordsru.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun AuthorWidget(
    authorViewDto: AuthorViewDto,
    onClick: (authorId: Int) -> Unit,
) {
    Text(
        modifier = Modifier.clickable { onClick(authorViewDto.id) },
        text = authorViewDto.name,
        color = YourChordsRuTheme.colors.text,
    )
}