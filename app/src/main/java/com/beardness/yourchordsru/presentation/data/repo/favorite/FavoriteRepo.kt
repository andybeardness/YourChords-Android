package com.beardness.yourchordsru.presentation.data.repo.favorite

import com.beardness.yourchordsru.presentation.data.datasource.favorite.IFavoriteDataSource
import com.beardness.yourchordsru.presentation.data.repo.dto.FavoriteAuthorRepoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.FavoriteSongRepoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.favoriteAuthorSourceDtoToRepoDto
import com.beardness.yourchordsru.presentation.data.repo.dto.favoriteSongSourceDtoToRepoDto
import javax.inject.Inject

class FavoriteRepo @Inject constructor(
    private val favoriteDataSource: IFavoriteDataSource,
) : IFavoriteRepo {
    override suspend fun authors(): List<FavoriteAuthorRepoDto> {
        return favoriteDataSource
            .authors()
            .favoriteAuthorSourceDtoToRepoDto()
    }

    override suspend fun songs(): List<FavoriteSongRepoDto> {
        return favoriteDataSource
            .songs()
            .favoriteSongSourceDtoToRepoDto()
    }

    override suspend fun insertAuthor(authorId: Int) {
        favoriteDataSource.insertAuthor(authorId = authorId)
    }

    override suspend fun insertSong(authorId: Int, songId: Int) {
        favoriteDataSource.insertSong(authorId = authorId, songId = songId)
    }

    override suspend fun removeAuthor(authorId: Int) {
        favoriteDataSource.removeAuthor(authorId = authorId)
    }

    override suspend fun removeSong(authorId: Int, songId: Int) {
        favoriteDataSource.removeSong(authorId = authorId, songId = songId)
    }
}