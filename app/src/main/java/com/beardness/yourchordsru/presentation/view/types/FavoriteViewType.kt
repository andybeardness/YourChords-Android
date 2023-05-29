package com.beardness.yourchordsru.presentation.view.types

import com.beardness.yourchordsru.presentation.domain.type.FavoriteDomainType

enum class FavoriteViewType {
    DEFAULT, FAVORITE, PARTLY
}

fun FavoriteDomainType.viewType(): FavoriteViewType =
    when (this) {
        FavoriteDomainType.DEFAULT -> FavoriteViewType.DEFAULT
        FavoriteDomainType.FAVORITE -> FavoriteViewType.FAVORITE
        FavoriteDomainType.PARTLY -> FavoriteViewType.PARTLY
    }


