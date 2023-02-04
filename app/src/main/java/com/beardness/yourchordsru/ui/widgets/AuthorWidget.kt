package com.beardness.yourchordsru.ui.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto

@Composable
fun AuthorWidget(authorViewDto: AuthorViewDto) {
    Text(text = authorViewDto.name)
}