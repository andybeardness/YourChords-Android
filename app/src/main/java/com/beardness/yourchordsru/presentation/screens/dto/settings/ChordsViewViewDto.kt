package com.beardness.yourchordsru.presentation.screens.dto.settings

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.core.dto.ChordsViewCoreDto

data class ChordsViewViewDto(
    val backgroundColor: Color,
    val textColor: Color,
    val chordsColor: Color,
    val fontSize: Int,
)

fun ChordsViewCoreDto.viewDto(): ChordsViewViewDto =
    ChordsViewViewDto(
        backgroundColor = this.backgroundColor,
        textColor = this.textColor,
        chordsColor = this.chordsColor,
        fontSize = this.fontSize,
    )
