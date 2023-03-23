package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.presentation.core.authors.AuthorsCore
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.core.favorite.FavoriteCore
import com.beardness.yourchordsru.presentation.core.favorite.IFavoriteCore
import com.beardness.yourchordsru.presentation.core.screen.awake.IScreenAwakeCore
import com.beardness.yourchordsru.presentation.core.screen.awake.ScreenAwakeCore
import com.beardness.yourchordsru.presentation.core.search.ISearchCore
import com.beardness.yourchordsru.presentation.core.search.SearchCore
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.core.settings.SettingsCore
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.core.songs.SongsCore
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.favorite.IFavoriteRepo
import com.beardness.yourchordsru.presentation.data.repo.settings.ISettingsRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideAuthorsCore(
        authorsRepo: IAuthorsRepo,
    ): IAuthorsCore =
        AuthorsCore(
            authorsRepo = authorsRepo,
        )

    @Provides
    @Singleton
    fun provideSongsCore(
        songsRepo: ISongsRepo
    ): ISongsCore =
        SongsCore(
            songsRepo = songsRepo,
        )

    @Provides
    @Singleton
    fun provideSearchCore(
        authorsRepo: IAuthorsRepo,
        songsRepo: ISongsRepo,
        favoriteRepo: IFavoriteRepo
    ): ISearchCore =
        SearchCore(
            authorsRepo = authorsRepo,
            songsRepo = songsRepo,
            favoriteRepo = favoriteRepo,
        )

    @Provides
    @Singleton
    fun provideSettingsCore(
        settingsRepo: ISettingsRepo
    ): ISettingsCore =
        SettingsCore(
            settingsRepo = settingsRepo,
        )

    @Provides
    @Singleton
    fun provideFavoriteCore(
        favoriteRepo: IFavoriteRepo,
    ): IFavoriteCore =
        FavoriteCore(
            favoriteRepo = favoriteRepo,
        )

    @Provides
    @Singleton
    fun provideScreenAwakeCore(): IScreenAwakeCore =
        ScreenAwakeCore()
}