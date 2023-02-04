package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.presentation.data.datasource.authors.IAuthorsDataSource
import com.beardness.yourchordsru.presentation.data.repo.authors.AuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
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
}