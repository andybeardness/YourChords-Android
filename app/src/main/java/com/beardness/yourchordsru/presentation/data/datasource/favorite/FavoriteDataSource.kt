package com.beardness.yourchordsru.presentation.data.datasource.favorite

import com.beardness.yourchordsru.data.db.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.data.db.dao.FavoriteSongsDao
import com.beardness.yourchordsru.data.db.entity.FavoriteAuthorEntity
import com.beardness.yourchordsru.data.db.entity.FavoriteSongEntity
import com.beardness.yourchordsru.presentation.data.datasource.dto.FavoriteAuthorSourceDto
import com.beardness.yourchordsru.presentation.data.datasource.dto.FavoriteSongSourceDto
import com.beardness.yourchordsru.presentation.data.datasource.dto.favoriteAuthorEntitiesToSourceDto
import com.beardness.yourchordsru.presentation.data.datasource.dto.favoriteSongEntitiesToSourceDto
import javax.inject.Inject

class FavoriteDataSource @Inject constructor(
    private val favoriteAuthorsDao: FavoriteAuthorsDao,
    private val favoriteSongsDao: FavoriteSongsDao,
) : IFavoriteDataSource {

    override suspend fun authors(): List<FavoriteAuthorSourceDto> {
        return favoriteAuthorsDao
            .all()
            .favoriteAuthorEntitiesToSourceDto()
    }

    override suspend fun songs(): List<FavoriteSongSourceDto> {
        return favoriteSongsDao
            .all()
            .favoriteSongEntitiesToSourceDto()
    }

    override suspend fun insertAuthor(authorId: Int) {
        val entity = FavoriteAuthorEntity(
            id = 0,
            authorId = authorId,
        )

        favoriteAuthorsDao.insert(favoriteAuthorEntity = entity)
    }

    override suspend fun insertSong(authorId: Int, songId: Int) {
        val entity = FavoriteSongEntity(
            id = 0,
            authorId = authorId,
            songId = songId,
        )

        favoriteSongsDao.insert(favoriteSongEntity = entity)
    }

    override suspend fun removeAuthor(authorId: Int) {
        favoriteAuthorsDao.remove(authorId = authorId)
    }

    override suspend fun removeSong(authorId: Int, songId: Int) {
        favoriteSongsDao.remove(authorId = authorId, songId = songId,)
    }
}