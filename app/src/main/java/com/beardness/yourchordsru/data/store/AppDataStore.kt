package com.beardness.yourchordsru.data.store

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import com.beardness.yourchordsru.data.store.dto.ChordsViewDataStoreDto
import com.beardness.yourchordsru.data.store.extensions.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDataStore @Inject constructor(
    context: Context,
): IAppDataStore {

    companion object {
        private val IS_FIRST_LAUNCH_KEY = booleanPreferencesKey(name = "IS_FIRST_LAUNCH_KEY")
        private val THEME_CODE_KEY = intPreferencesKey(name = "THEME_CODE_KEY")
        private val BACKGROUND_COLOR_KEY = longPreferencesKey(name = "BACKGROUND_COLOR_KEY")
        private val TEXT_COLOR_KEY = longPreferencesKey(name = "TEXT_COLOR_KEY")
        private val CHORDS_COLOR_KEY = longPreferencesKey(name = "CHORDS_COLOR_KEY")
        private val FONT_SIZE_KEY = intPreferencesKey(name = "FONT_SIZE_KEY")
        private val SONG_SORT_TYPE_CODE_KEY = intPreferencesKey(name = "SONG_SORT_TYPE_CODE_KEY")
    }

    private val dataStore = context.dataStore

    override val isFirstLaunch: Flow<Boolean> =
        dataStore
            .data
            .map { preferences ->
                preferences[IS_FIRST_LAUNCH_KEY] ?: true
            }

    override val chordsView: Flow<ChordsViewDataStoreDto> =
        dataStore
            .data
            .map { preferences ->
                val backgroundColor = preferences[BACKGROUND_COLOR_KEY] ?: 0L
                val textColor = preferences[TEXT_COLOR_KEY] ?: 0L
                val chordsColor = preferences[CHORDS_COLOR_KEY] ?: 0L
                val fontSize = preferences[FONT_SIZE_KEY] ?: 0

                ChordsViewDataStoreDto(
                    backgroundColor = backgroundColor,
                    textColor = textColor,
                    chordsColor = chordsColor,
                    fontSize = fontSize,
                )
            }

    override val themeCode: Flow<Int> =
        dataStore
            .data
            .map { preferences ->
                preferences[THEME_CODE_KEY] ?: 0
            }

    override val songSortTypeCode: Flow<Int> =
        dataStore
            .data
            .map { preferences ->
                preferences[SONG_SORT_TYPE_CODE_KEY] ?: 0
            }

    override suspend fun setFirstLaunch() {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[IS_FIRST_LAUNCH_KEY] = false
            }
    }

    override suspend fun setThemeCode(code: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[THEME_CODE_KEY] = code
            }
    }

    override suspend fun setBackgroundColor(color: Long) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[BACKGROUND_COLOR_KEY] = color
            }
    }

    override suspend fun setTextColor(color: Long) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[TEXT_COLOR_KEY] = color
            }
    }

    override suspend fun setChordsColor(color: Long) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[CHORDS_COLOR_KEY] = color
            }
    }

    override suspend fun setFontSize(size: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[FONT_SIZE_KEY] = size
            }
    }

    override suspend fun setSongsSortType(code: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences[SONG_SORT_TYPE_CODE_KEY] = code
            }
    }
}