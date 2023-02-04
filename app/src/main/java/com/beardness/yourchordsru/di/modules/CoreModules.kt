package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.presentation.core.authors.AuthorsCore
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.core.songs.SongsCore
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModules {

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
}