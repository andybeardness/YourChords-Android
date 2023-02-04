package com.beardness.yourchordsru.presentation.screens.home

import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import kotlinx.coroutines.flow.Flow

interface IHomeScreenViewModel {
    val authors: Flow<List<AuthorViewDto>>
}