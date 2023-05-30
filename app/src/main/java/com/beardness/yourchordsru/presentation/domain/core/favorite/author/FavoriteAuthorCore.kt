package com.beardness.yourchordsru.presentation.domain.core.favorite.author

import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteAuthorEntity
import com.beardness.yourchordsru.utils.extensions.isNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteAuthorCore @Inject constructor(
    private val favoriteAuthorsDao: FavoriteAuthorsDao,
) : FavoriteAuthorCoreProtocol {

    private val _favoriteAuthorsFromDb = favoriteAuthorsDao.flow()

    override val favoriteAuthorsIds =
        _favoriteAuthorsFromDb
            .map { favoriteAuthors ->
                favoriteAuthors.map { favoriteAuthorEntity -> favoriteAuthorEntity.authorId }
            }

    override suspend fun changeAuthorFavorite(authorId: Int) {
        val isFavorite =
            favoriteAuthorsDao.author(id = authorId)
                .isNotNull()

        if (isFavorite) {
            favoriteAuthorsDao.remove(authorId = authorId)
        } else {
            val entity = FavoriteAuthorEntity(
                id = 0,
                authorId = authorId,
            )

            favoriteAuthorsDao.insert(favoriteAuthorEntity = entity)
        }
    }

    override suspend fun doesAuthorInFavorite(authorId: Int): Boolean {
        return _favoriteAuthorsFromDb
            .map { authorsFromDb ->
                authorsFromDb.firstOrNull { favoriteAuthorEntity ->
                    favoriteAuthorEntity.authorId == authorId
                }
            }
            .isNotNull()
    }
}