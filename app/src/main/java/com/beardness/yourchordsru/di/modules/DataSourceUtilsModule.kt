package com.beardness.yourchordsru.di.modules

import android.content.Context
import com.beardness.yourchordsru.utils.csvreader.authors.AuthorsCsvReader
import com.beardness.yourchordsru.utils.csvreader.authors.IAuthorsCsvReader
import com.beardness.yourchordsru.utils.csvreader.songs.ISongsCsvReader
import com.beardness.yourchordsru.utils.csvreader.songs.SongsCsvReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceUtilsModule {

    @Provides
    @Singleton
    fun provideAuthorsCsvReader(
        @ApplicationContext context: Context,
    ): IAuthorsCsvReader =
        AuthorsCsvReader(
            context = context,
        )

    @Provides
    @Singleton
    fun provideSongsCsvReader(
        @ApplicationContext context: Context,
    ): ISongsCsvReader =
        SongsCsvReader(
            context = context,
        )
}