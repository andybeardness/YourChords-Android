package com.beardness.yourchordsru.presentation.domain.core.favorite.author

import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteAuthorEntity
import com.beardness.yourchordsru.utils.extensions.isNotNull
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FavoriteAuthorCore @Inject constructor(
    private val favoriteAuthorsDao: FavoriteAuthorsDao,
) : FavoriteAuthorCoreProtocol {

    private val _favoriteAuthorsFromDb = MutableStateFlow<List<FavoriteAuthorEntity>>(value = emptyList())

    override val favoriteAuthorsIds =
        _favoriteAuthorsFromDb
            .map { favoriteAuthors ->
                favoriteAuthors.map { favoriteAuthorEntity -> favoriteAuthorEntity.authorId }
            }

    override suspend fun setup() {
        favoriteAuthorsDao
            .flow()
            .onEach { favoriteAuthorEntities ->
                _favoriteAuthorsFromDb.emit(value = favoriteAuthorEntities)
            }
    }

    override suspend fun changeAuthorFavorite(authorId: Int) {
        val isFavorite =
            _favoriteAuthorsFromDb
                .value
                .firstOrNull { favoriteAuthorEntity -> favoriteAuthorEntity.authorId == authorId }
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
            .value
            .firstOrNull { favoriteAuthorEntity -> favoriteAuthorEntity.authorId == authorId }
            .isNotNull()
    }
}