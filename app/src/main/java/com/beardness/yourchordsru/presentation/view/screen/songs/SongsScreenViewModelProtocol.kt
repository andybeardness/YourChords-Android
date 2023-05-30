package com.beardness.yourchordsru.presentation.view.screen.songs

import com.beardness.yourchordsru.presentation.entity.Song
import com.beardness.yourchordsru.presentation.types.FavoriteType
import kotlinx.coroutines.flow.Flow

interface SongsScreenViewModelProtocol {
    fun setup(authorId: Int)

    val authorName: Flow<String>
    val authorFavoriteType: Flow<FavoriteType>
    val songs: Flow<List<Song>>
    val favoriteSongsIds: Flow<List<Int>>
    val authorId: Flow<Int>
}
