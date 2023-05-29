package com.beardness.yourchordsru.presentation.view.dto

import com.beardness.yourchordsru.presentation.view.types.FavoriteViewType

class AuthorViewDto(
    val id: Int,
    val name: String,
    val songsCount: Int,
    val ratingCount: Int,
    val favoriteType: FavoriteViewType,
)