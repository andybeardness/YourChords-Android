package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.data.store.IAppDataStore
import com.beardness.yourchordsru.presentation.data.datasource.authors.IAuthorsDataSource
import com.beardness.yourchordsru.presentation.data.datasource.favorite.IFavoriteDataSource
import com.beardness.yourchordsru.presentation.data.datasource.songs.ISongsDataSource
import com.beardness.yourchordsru.presentation.data.repo.authors.AuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.favorite.FavoriteRepo
import com.beardness.yourchordsru.presentation.data.repo.favorite.IFavoriteRepo
import com.beardness.yourchordsru.presentation.data.repo.settings.ISettingsRepo
import com.beardness.yourchordsru.presentation.data.repo.settings.SettingsRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.SongsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideAuthorsRepo(
        authorsDataSource: IAuthorsDataSource,
    ): IAuthorsRepo =
        AuthorsRepo(
            authorsDataSource = authorsDataSource,
        )

    @Provides
    @Singleton
    fun provideSongsRepo(
        songsDataSource: ISongsDataSource,
    ): ISongsRepo =
        SongsRepo(
            songsDataSource = songsDataSource,
        )

    @Provides
    @Singleton
    fun provideSettingsRepo(
        appDataStore: IAppDataStore,
    ): ISettingsRepo =
        SettingsRepo(
            appDataStore = appDataStore,
        )

    @Provides
    @Singleton
    fun provideFavoriteRepo(
        favoriteDataSource: IFavoriteDataSource,
    ): IFavoriteRepo =
        FavoriteRepo(
            favoriteDataSource = favoriteDataSource,
        )
}