package com.beardness.yourchordsru.presentation.domain.core.favorite.song

import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteSongsDao
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteSongEntity
import com.beardness.yourchordsru.utils.extensions.isNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteSongCore @Inject constructor(
    private val favoriteSongsDao: FavoriteSongsDao,
) : FavoriteSongCoreProtocol {

    private val _favoriteSongsFromDb = favoriteSongsDao.flow()

    override val favoriteSongsAuthorsIds =
        _favoriteSongsFromDb
            .map { favoriteSongEntities ->
                favoriteSongEntities.map { favoriteSongEntity -> favoriteSongEntity.authorId }
            }

    override val favoriteSongsIds =
        _favoriteSongsFromDb
            .map { favoriteSongEntities ->
                favoriteSongEntities.map { favoriteSongEntity -> favoriteSongEntity.songId }
            }

    override suspend fun changeSongFavorite(authorId: Int, songId: Int) {
        val isFavorite =
            favoriteSongsDao
                .song(authorId = authorId, songId = songId)
                .isNotNull()

        if (isFavorite) {
            favoriteSongsDao.remove(authorId = authorId, songId = songId)
        } else {
            val entity = FavoriteSongEntity(
                id = 0,
                authorId = authorId,
                songId = songId,
            )

            favoriteSongsDao.insert(favoriteSongEntity = entity)
        }
    }

    override suspend fun doesSongInFavorite(authorId: Int, songId: Int): Boolean =
        favoriteSongsDao
            .song(authorId = authorId, songId = songId)
            .isNotNull()

    override suspend fun doesAuthorHasSongsInFavorite(authorId: Int): Boolean =
        favoriteSongsDao
            .all()
            .firstOrNull { favoriteSongEntity -> favoriteSongEntity.authorId == authorId }
            .isNotNull()

    override suspend fun favoriteSongsIds(authorId: Int): List<Int> =
        favoriteSongsDao
            .all()
            .filter { favoriteSongEntity -> favoriteSongEntity.authorId == authorId }
            .map { favoriteSongEntity -> favoriteSongEntity.songId }
}