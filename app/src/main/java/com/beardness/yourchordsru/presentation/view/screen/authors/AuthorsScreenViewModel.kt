package com.beardness.yourchordsru.presentation.view.screen.authors

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCaseProtocol
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsScreenViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCaseProtocol,
    private val favoriteUseCase: FavoriteUseCaseProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), AuthorsScreenViewModelProtocol {

    override val authors =
        authorsUseCase
            .authors
            .map { authors -> authors.sortedBy { author -> author.name } }

    override val favoriteAuthorsIds =
        favoriteUseCase
            .favoriteAuthorsIds

    override val favoriteSongsAuthorsIds =
        favoriteUseCase
            .favoriteSongsAuthorsIds

    override fun swapAuthorFavorite(authorId: Int) {
        ioCoroutineScope.launch {
            favoriteUseCase.changeAuthorFavorite(authorId = authorId)
        }
    }
}