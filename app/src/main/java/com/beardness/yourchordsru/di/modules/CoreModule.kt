package com.beardness.yourchordsru.di.modules

import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteAuthorsDao
import com.beardness.yourchordsru.presentation.data.database.dao.FavoriteSongsDao
import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.domain.core.authors.AuthorsCore
import com.beardness.yourchordsru.presentation.domain.core.authors.AuthorsCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.favorite.author.FavoriteAuthorCore
import com.beardness.yourchordsru.presentation.domain.core.favorite.author.FavoriteAuthorCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.favorite.song.FavoriteSongCore
import com.beardness.yourchordsru.presentation.domain.core.favorite.song.FavoriteSongCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.search.SearchCore
import com.beardness.yourchordsru.presentation.domain.core.search.SearchCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.settings.SettingsCore
import com.beardness.yourchordsru.presentation.domain.core.settings.SettingsCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.songs.SongsCore
import com.beardness.yourchordsru.presentation.domain.core.songs.SongsCoreProtocol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideAuthorsCore(
        authorsCsvReader: AuthorsCsvReaderProtocol,
    ): AuthorsCoreProtocol =
        AuthorsCore(
            authorsCsvReader = authorsCsvReader,
        )

    @Provides
    @Singleton
    fun provideSongsCore(
        songsCsvReader: SongsCsvReaderProtocol,
    ): SongsCoreProtocol =
        SongsCore(
            songsCsvReader = songsCsvReader,
        )

    @Provides
    @Singleton
    fun provideSearchCore(
        authorsCsvReader: AuthorsCsvReaderProtocol,
        songsCsvReader: SongsCsvReaderProtocol,
    ): SearchCoreProtocol =
        SearchCore(
            authorsCsvReader = authorsCsvReader,
            songsCsvReader = songsCsvReader,
        )

    @Provides
    @Singleton
    fun provideSettingsCore(
    ): SettingsCoreProtocol =
        SettingsCore()

    @Provides
    @Singleton
    fun provideFavoriteAuthorCore(
        favoriteAuthorsDao: FavoriteAuthorsDao,
    ): FavoriteAuthorCoreProtocol =
        FavoriteAuthorCore(
            favoriteAuthorsDao = favoriteAuthorsDao,
        )

    @Provides
    @Singleton
    fun provideFavoriteSongCore(
        favoriteSongsDao: FavoriteSongsDao,
    ): FavoriteSongCoreProtocol =
        FavoriteSongCore(
            favoriteSongsDao = favoriteSongsDao,
        )
}