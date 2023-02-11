package com.beardness.yourchordsru.presentation.core.dto

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.data.repo.dto.ChordsViewRepoDto
import com.beardness.yourchordsru.utils.extensions.composeColor

data class ChordsViewCoreDto(
    val backgroundColor: Color,
    val textColor: Color,
    val chordsColor: Color,
    val fontSize: Int,
)

fun ChordsViewRepoDto.coreDto(): ChordsViewCoreDto =
    ChordsViewCoreDto(
        backgroundColor = this.backgroundColor.composeColor(),
        textColor = this.textColor.composeColor(),
        chordsColor = this.chordsColor.composeColor(),
        fontSize = this.fontSize,
    )
