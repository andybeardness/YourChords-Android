package com.beardness.yourchordsru.presentation.data.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.beardness.yourchordsru.presentation.data.storage.extensions.dataStore
import com.beardness.yourchordsru.presentation.data.storage.keys.DataStoreKey
import com.beardness.yourchordsru.presentation.data.storage.keys.integer
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDataStore @Inject constructor(
    context: Context,
) : AppDataStoreProtocol {

    private val dataStore = context.dataStore

    override val fontSize = dataStore.data.map { preferences ->
        preferences.integer(key = DataStoreKey.FONT_SIZE)
    }

    override val viewMode = dataStore.data.map { preferences ->
        preferences.integer(key = DataStoreKey.VIEW_MODE)
    }

    override suspend fun fontSize(): Int? =
        dataStore
            .data
            .map { preferences -> preferences.integer(key = DataStoreKey.FONT_SIZE) }
            .firstOrNull()

    override suspend fun viewModeCode(): Int? =
        dataStore
            .data
            .map { preferences -> preferences.integer(key = DataStoreKey.VIEW_MODE) }
            .firstOrNull()

    override suspend fun updateFontSize(update: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences
                    .integer(
                        key = DataStoreKey.FONT_SIZE,
                        value = update,
                    )
            }
    }

    override suspend fun updateViewMode(update: Int) {
        dataStore
            .edit { mutablePreferences ->
                mutablePreferences
                    .integer(
                        key = DataStoreKey.VIEW_MODE,
                        value = update,
                    )
            }
    }
}