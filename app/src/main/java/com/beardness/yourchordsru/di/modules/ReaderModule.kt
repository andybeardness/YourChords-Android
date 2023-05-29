package com.beardness.yourchordsru.di.modules

import android.content.Context
import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReader
import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReader
import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReaderProtocol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReaderModule {

    @Provides
    @Singleton
    fun provideAuthorsCsvReader(
        @ApplicationContext context: Context,
    ): AuthorsCsvReaderProtocol =
        AuthorsCsvReader(
            context = context,
        )

    @Provides
    @Singleton
    fun provideSongsCsvReader(
        @ApplicationContext context: Context,
    ): SongsCsvReaderProtocol =
        SongsCsvReader(
            context = context,
        )
}