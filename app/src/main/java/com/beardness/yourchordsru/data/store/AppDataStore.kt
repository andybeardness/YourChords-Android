package com.beardness.yourchordsru.data.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.beardness.yourchordsru.config.ChordsConfig
import com.beardness.yourchordsru.data.store.extensions.dataStore
import com.beardness.yourchordsru.data.store.keys.DataStoreKey
import com.beardness.yourchordsru.data.store.keys.integer
import com.beardness.yourchordsru.data.store.keys.long
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDataStore @Inject constructor(
    context: Context,
): IAppDataStore {

    private val dataStore = context.dataStore

    override val backgroundColor: Flow<Long> =
        dataStore
            .data
            .map { preferences ->
                preferences.long(
                    key = DataStoreKey.BACKGROUND_COLOR,
                    default = ChordsConfig.DEFAULT_BACKGROUND_COLOR,
                )
            }

    override val textColor: Flow<Long> =
        dataStore
            .data
            .map { preferences ->
                preferences.long(
                    key = DataStoreKey.TEXT_COLOR,
                    default = ChordsConfig.DEFAULT_TEXT_COLOR,
                )
            }

    override val chordsColor: Flow<Long> =
        dataStore
            .data
            .map { preferences ->
                preferences.long(
                    key = DataStoreKey.CHORDS_COLOR,
                    default = ChordsConfig.DEFAULT_CHORDS_COLOR,
                )
            }

    override val fontSize: Flow<Int> =
        dataStore
            .data
            .map { preferences ->
                preferences.integer(
                    key = DataStoreKey.FONT_SIZE,
                    default = ChordsConfig.DEFAULT_FONT_SIZE,
                )
            }

    override val themeCode: Flow<Int> =
        dataStore
            .data
            .map { preferences ->
                preferences.integer(
                    key = DataStoreKey.THEME_CODE,
                    default = ChordsConfig.DEFAULT_THEME_CODE,
                )
            }

    override val authorSortTypeCode: Flow<Int> =
        dataStore
            .data
            .map { preferences ->
                preferences.integer(
                    key = DataStoreKey.AUTHOR_SORT_TYPE,
                    default = ChordsConfig.DEFAULT_AUTHOR_SORT_TYPE,
                )
            }

    override val songSortTypeCode: Flow<Int> =
        dataStore
            .data
            .map { preferences ->
                preferences.integer(
                    key = DataStoreKey.SONG_SORT_TYPE,
                    default = ChordsConfig.DEFAULT_SONG_SORT_TYPE,
                )
            }

    override suspend fun setThemeCode(code: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.integer(
                    key = DataStoreKey.THEME_CODE,
                    value = code,
                )
            }
    }

    override suspend fun setBackgroundColor(color: Long) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.long(
                    key = DataStoreKey.BACKGROUND_COLOR,
                    value = color,
                )
            }
    }

    override suspend fun setTextColor(color: Long) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.long(
                    key = DataStoreKey.TEXT_COLOR,
                    value = color
                )
            }
    }

    override suspend fun setChordsColor(color: Long) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.long(
                    key = DataStoreKey.CHORDS_COLOR,
                    value = color,
                )
            }
    }

    override suspend fun setFontSize(size: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.integer(
                    key = DataStoreKey.FONT_SIZE,
                    value = size,
                )
            }
    }

    override suspend fun setAuthorsSortType(code: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.integer(
                    key = DataStoreKey.AUTHOR_SORT_TYPE,
                    value = code,
                )
            }
    }

    override suspend fun setSongsSortType(code: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences.integer(
                    key = DataStoreKey.SONG_SORT_TYPE,
                    value = code,
                )
            }
    }
}