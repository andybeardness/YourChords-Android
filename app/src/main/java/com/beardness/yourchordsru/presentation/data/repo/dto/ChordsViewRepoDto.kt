package com.beardness.yourchordsru.presentation.data.repo.dto

import com.beardness.yourchordsru.data.store.dto.ChordsViewDataStoreDto

data class ChordsViewRepoDto(
    val backgroundColor: Long,
    val textColor: Long,
    val chordsColor: Long,
    val fontSize: Int,
)

fun ChordsViewDataStoreDto.repoDto(): ChordsViewRepoDto =
    ChordsViewRepoDto(
        backgroundColor = this.backgroundColor,
        textColor = this.textColor,
        chordsColor = this.chordsColor,
        fontSize = this.fontSize,
    )
