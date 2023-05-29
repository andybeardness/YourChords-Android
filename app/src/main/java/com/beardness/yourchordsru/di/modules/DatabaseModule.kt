package com.beardness.yourchordsru.di.modules

import android.content.Context
import androidx.room.Room
import com.beardness.yourchordsru.presentation.data.database.AppDatabase
import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteSongsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase =
        Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "your_chords_ru_database",
        ).build()

    @Provides
    @Singleton
    fun provideFavoriteAuthorsDao(
        database: AppDatabase,
    ): FavoriteAuthorsDao =
        database.favoriteAuthorsDao()

    @Provides
    @Singleton
    fun provideFavoriteSongsDao(
        database: AppDatabase,
    ): FavoriteSongsDao =
        database.favoriteSongsDao()
}