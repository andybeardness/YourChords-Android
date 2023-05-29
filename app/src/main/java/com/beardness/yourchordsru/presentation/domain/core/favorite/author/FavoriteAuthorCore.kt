package com.beardness.yourchordsru.presentation.domain.core.favorite.author

import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.presentation.data.database.entity.FavoriteAuthorEntity
import com.beardness.yourchordsru.presentation.domain.dto.FavoriteAuthorDomainDto
import com.beardness.yourchordsru.presentation.domain.dto.toDomainDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FavoriteAuthorCore @Inject constructor(
    private val favoriteAuthorsDao: FavoriteAuthorsDao,
) : FavoriteAuthorCoreProtocol {

    private val _favoriteAuthors = MutableStateFlow<List<FavoriteAuthorDomainDto>>(value = emptyList())
    override val favoriteAuthors = _favoriteAuthors.asStateFlow()

    override suspend fun setup() {
        favoriteAuthorsDao
            .flow()
            .map { authors ->
                authors.map { favoriteAuthorEntity -> favoriteAuthorEntity.toDomainDto() }
            }
            .onEach { authors ->
                _favoriteAuthors.emit(value = authors)
            }
    }

    override suspend fun changeAuthorFavorite(authorId: Int) {
        val isFavorite =
            _favoriteAuthors
                .value
                .firstOrNull { author -> author.authorId == authorId } != null

        if (isFavorite) {
            favoriteAuthorsDao.remove(
                authorId = authorId,
            )
        } else {
            favoriteAuthorsDao.insert(
                favoriteAuthorEntity = FavoriteAuthorEntity(
                    id = 0,
                    authorId = authorId,
                ),
            )
        }

        setup()
    }
}