package com.beardness.yourchordsru.presentation.domain.core.favorite.song

import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteSongsDao
import com.beardness.yourchordsru.presentation.domain.dto.FavoriteSongDomainDto
import com.beardness.yourchordsru.presentation.domain.dto.toDomainDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FavoriteSongCore @Inject constructor(
    private val favoriteSongsDao: FavoriteSongsDao,
) : FavoriteSongCoreProtocol {

    private val _favoriteSongs = MutableStateFlow<List<FavoriteSongDomainDto>>(value = emptyList())
    override val favoriteSongs = _favoriteSongs.asStateFlow()

    override suspend fun setup() {
        favoriteSongsDao
            .flow()
            .map { songs ->
                songs.map { favoriteSongEntity -> favoriteSongEntity.toDomainDto() }
            }
            .onEach { songs ->
                _favoriteSongs.emit(value = songs)
            }
    }

    override suspend fun changeSongFavorite(authorId: Int, songId: Int) {
        favoriteSongsDao
            .flow()
            .map { songs ->
                songs.map { favoriteSongEntity -> favoriteSongEntity.toDomainDto() }
            }
            .onEach { songs ->
                _favoriteSongs.emit(value = songs)
            }
    }
}