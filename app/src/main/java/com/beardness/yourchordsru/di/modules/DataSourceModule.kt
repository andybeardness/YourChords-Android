package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.data.db.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.data.db.dao.FavoriteSongsDao
import com.beardness.yourchordsru.presentation.data.datasource.authors.AuthorsDataSource
import com.beardness.yourchordsru.presentation.data.datasource.authors.IAuthorsDataSource
import com.beardness.yourchordsru.presentation.data.datasource.favorite.FavoriteDataSource
import com.beardness.yourchordsru.presentation.data.datasource.favorite.IFavoriteDataSource
import com.beardness.yourchordsru.presentation.data.datasource.songs.ISongsDataSource
import com.beardness.yourchordsru.presentation.data.datasource.songs.SongsDataSource
import com.beardness.yourchordsru.utils.csvreader.authors.IAuthorsCsvReader
import com.beardness.yourchordsru.utils.csvreader.songs.ISongsCsvReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideAuthorsDataSource(
        authorsCsvReader: IAuthorsCsvReader
    ): IAuthorsDataSource =
        AuthorsDataSource(
            authorsCsvReader = authorsCsvReader,
        )

    @Provides
    @Singleton
    fun provideSongsDataSource(
        songsCsvReader: ISongsCsvReader,
    ): ISongsDataSource =
        SongsDataSource(
            songsCsvReader = songsCsvReader,
        )

    @Provides
    @Singleton
    fun provideFavoriteDataSource(
        favoriteAuthorsDao: FavoriteAuthorsDao,
        favoriteSongsDao: FavoriteSongsDao,
    ): IFavoriteDataSource =
        FavoriteDataSource(
            favoriteAuthorsDao = favoriteAuthorsDao,
            favoriteSongsDao = favoriteSongsDao,
        )
}