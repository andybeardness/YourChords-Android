package com.beardness.yourchordsru.presentation.view.types

import com.beardness.yourchordsru.presentation.types.FavoriteType

enum class FavoriteViewType {
    DEFAULT, FAVORITE, PARTLY
}

fun FavoriteType.viewType(): FavoriteViewType =
    when (this) {
        FavoriteType.DEFAULT -> FavoriteViewType.DEFAULT
        FavoriteType.FAVORITE -> FavoriteViewType.FAVORITE
        FavoriteType.PARTLY -> FavoriteViewType.PARTLY
    }


