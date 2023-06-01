package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.helpers.colors.html.HtmlColorHelper
import com.beardness.yourchordsru.helpers.colors.html.HtmlColorHelperProtocol
import com.beardness.yourchordsru.helpers.fontsize.FontSizeHelper
import com.beardness.yourchordsru.helpers.fontsize.FontSizeHelperProtocol
import com.beardness.yourchordsru.helpers.viewmode.ViewModeHelper
import com.beardness.yourchordsru.helpers.viewmode.ViewModeHelperProtocol
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
    ): ViewModeHelperProtocol =
        ViewModeHelper()

    @Provides
    @Singleton
    fun provideFontSizeHelper(
    ): FontSizeHelperProtocol =
        FontSizeHelper()
}