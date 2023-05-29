package com.beardness.yourchordsru.presentation.view.screen.author

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCaseProtocol
import com.beardness.yourchordsru.presentation.view.dto.AuthorViewDto
import com.beardness.yourchordsru.presentation.view.types.FavoriteViewType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorScreenViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCaseProtocol,
    private val favoriteUseCase: FavoriteUseCaseProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), AuthorScreenViewModelProtocol {

    override val authors =
        combine(
            authorsUseCase.authors,
            favoriteUseCase.favoriteAuthors,
            favoriteUseCase.favoriteSongs,
        ) { authors, favoriteAuthors, favoriteSongs ->

            authors.map { authorDomainDto ->
                val isAuthorFavorite =
                    favoriteAuthors
                        .firstOrNull { favoriteAuthorDomainDto ->
                            favoriteAuthorDomainDto.authorId == authorDomainDto.id
                        } != null

                val isAuthorsSongFavorite =
                    favoriteSongs
                        .firstOrNull { favoriteSongDomainDto ->
                            favoriteSongDomainDto.authorId == authorDomainDto.id
                        } != null

                val favoriteType = when {
                    isAuthorFavorite -> FavoriteViewType.FAVORITE
                    isAuthorsSongFavorite -> FavoriteViewType.PARTLY
                    else -> FavoriteViewType.DEFAULT
                }

                AuthorViewDto(
                    id = authorDomainDto.id,
                    name = authorDomainDto.name,
                    songsCount = authorDomainDto.songsCount,
                    ratingCount = authorDomainDto.ratingCount,
                    favoriteType = favoriteType,
                )

            }.sortedBy { authorViewDto -> authorViewDto.name }
        }

    override fun swapAuthorFavorite(authorId: Int) {
        ioCoroutineScope.launch {
            favoriteUseCase.changeAuthorFavorite(authorId = authorId)
        }
    }
}