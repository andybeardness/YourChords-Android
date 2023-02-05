package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.navigation.navigator.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideNavigator(): INavigator =
        Navigator()
}