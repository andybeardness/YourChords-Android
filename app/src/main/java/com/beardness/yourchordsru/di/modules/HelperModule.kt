package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.helpers.colors.html.HtmlColorHelper
import com.beardness.yourchordsru.helpers.colors.html.HtmlColorHelperProtocol
import com.beardness.yourchordsru.helpers.viewmode.ViewModeChooseHelper
import com.beardness.yourchordsru.helpers.viewmode.ViewModeChooseHelperProtocol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HelperModule {

    @Provides
    @Singleton
    fun provideHtmlColorHelper(
    ): HtmlColorHelperProtocol =
        HtmlColorHelper()

    @Provides
    @Singleton
    fun provideViewModeChooseHelper(
    ): ViewModeChooseHelperProtocol =
        ViewModeChooseHelper()
}