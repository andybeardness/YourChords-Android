package com.beardness.yourchordsru.di.modules

import android.content.Context
import com.beardness.yourchordsru.presentation.data.storage.AppDataStore
import com.beardness.yourchordsru.presentation.data.storage.AppDataStoreProtocol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideAppDataStore(
        @ApplicationContext context: Context,
    ): AppDataStoreProtocol =
        AppDataStore(
            context = context,
        )
}