package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.utils.html.HtmlBuilder
import com.beardness.yourchordsru.utils.html.IHtmlBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Provides
    @Singleton
    fun provideHtmlBuilder(): IHtmlBuilder =
        HtmlBuilder()
}