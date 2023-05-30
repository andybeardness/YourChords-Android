package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.presentation.domain.core.authors.AuthorsCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.favorite.author.FavoriteAuthorCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.favorite.song.FavoriteSongCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.songs.SongsCoreProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCase
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.chords.ChordsUseCase
import com.beardness.yourchordsru.presentation.domain.usecase.chords.ChordsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCase
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCase
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.startup.StartupUseCase
import com.beardness.yourchordsru.presentation.domain.usecase.startup.StartupUseCaseProtocol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideStartupUseCase(
        authorsCore: AuthorsCoreProtocol,
    ): StartupUseCaseProtocol =
        StartupUseCase(
            authorsCore = authorsCore,
        )

    @Provides
    @Singleton
    fun provideAuthorsUseCase(
        authorsCore: AuthorsCoreProtocol,
    ): AuthorsUseCaseProtocol =
        AuthorsUseCase(
            authorsCore = authorsCore,
        )

    @Provides
    @Singleton
    fun provideSongsUseCase(
        songsCore: SongsCoreProtocol,
    ): SongsUseCaseProtocol =
        SongsUseCase(
            songsCore = songsCore,
        )

    @Provides
    @Singleton
    fun provideChordsUseCase(
        songsCore: SongsCoreProtocol,
    ): ChordsUseCaseProtocol =
        ChordsUseCase(
            songsCore = songsCore,
        )

    @Provides
    @Singleton
    fun provideFavoriteUseCase(
        favoriteAuthorCore: FavoriteAuthorCoreProtocol,
        favoriteSongCore: FavoriteSongCoreProtocol,
    ): FavoriteUseCaseProtocol =
        FavoriteUseCase(
            favoriteAuthorCore = favoriteAuthorCore,
            favoriteSongCore = favoriteSongCore,
        )
}