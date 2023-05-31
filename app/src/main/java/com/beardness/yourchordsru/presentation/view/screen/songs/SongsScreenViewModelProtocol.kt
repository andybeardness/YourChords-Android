package com.beardness.yourchordsru.presentation.view.screen.songs

import com.beardness.yourchordsru.presentation.entity.Song
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.screen.songs.types.SongsSortType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SongsScreenViewModelProtocol {
    fun setup(authorId: Int)

    val authorName: Flow<String>
    val authorFavoriteType: Flow<FavoriteType>
    val songs: Flow<List<Song>>
    val favoriteSongsIds: Flow<List<Int>>
    val authorId: Flow<Int>
    fun swapSongFavoriteType(authorId: Int, songId: Int)
    val sortType: StateFlow<SongsSortType>
    fun swapSortType()
}
