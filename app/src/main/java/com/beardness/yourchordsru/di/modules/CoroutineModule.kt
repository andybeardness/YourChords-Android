package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.di.qualifiers.MainCoroutineScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @Provides
    @Singleton
    @MainCoroutineScope
    fun provideMainCoroutineScope(): CoroutineScope =
        CoroutineScope(context = SupervisorJob() + Dispatchers.Main)

    @Provides
    @Singleton
    @IoCoroutineScope
    fun provideIoCoroutineScope(): CoroutineScope =
        CoroutineScope(context = SupervisorJob() + Dispatchers.IO)
}