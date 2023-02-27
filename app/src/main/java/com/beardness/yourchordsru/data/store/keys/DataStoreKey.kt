package com.beardness.yourchordsru.data.store.keys

import androidx.datastore.preferences.core.*

enum class DataStoreKey(val type: DataStoreKeyType) {
    THEME_CODE(type = DataStoreKeyType.INTEGER),
    BACKGROUND_COLOR(type = DataStoreKeyType.LONG),
    TEXT_COLOR(type = DataStoreKeyType.LONG),
    CHORDS_COLOR(type = DataStoreKeyType.LONG),
    FONT_SIZE(type = DataStoreKeyType.INTEGER),
    AUTHOR_SORT_TYPE(type = DataStoreKeyType.INTEGER),
    SONG_SORT_TYPE(type = DataStoreKeyType.INTEGER),
}

fun DataStoreKey.booleanPreferenceKey() = booleanPreferencesKey(name = this.name)
fun DataStoreKey.integerPreferenceKey() = intPreferencesKey(name = this.name)
fun DataStoreKey.longPreferenceKey() = longPreferencesKey(name = this.name)

fun Preferences.boolean(key: DataStoreKey, default: Boolean): Boolean =
    if (key.type == DataStoreKeyType.BOOLEAN) {
        this[key.booleanPreferenceKey()] ?: default
    } else {
        default
    }

fun Preferences.boolean(key: DataStoreKey): Boolean? =
    if (key.type == DataStoreKeyType.BOOLEAN) {
        this[key.booleanPreferenceKey()]
    } else {
        null
    }

fun Preferences.integer(key: DataStoreKey, default: Int): Int =
    if (key.type == DataStoreKeyType.INTEGER) {
        this[key.integerPreferenceKey()] ?: default
    } else {
        default
    }

fun Preferences.integer(key: DataStoreKey): Int? =
    if (key.type == DataStoreKeyType.INTEGER) {
        this[key.integerPreferenceKey()]
    } else {
        null
    }

fun Preferences.long(key: DataStoreKey, default: Long): Long =
    if (key.type == DataStoreKeyType.LONG) {
        this[key.longPreferenceKey()] ?: default
    } else {
        default
    }

fun Preferences.long(key: DataStoreKey): Long? =
    if (key.type == DataStoreKeyType.INTEGER) {
        this[key.longPreferenceKey()]
    } else {
        null
    }

fun MutablePreferences.boolean(key: DataStoreKey, value: Boolean) {
    if (key.type == DataStoreKeyType.BOOLEAN) {
        this[key.booleanPreferenceKey()] = value
    }
}

fun MutablePreferences.integer(key: DataStoreKey, value: Int) {
    if (key.type == DataStoreKeyType.INTEGER) {
        this[key.integerPreferenceKey()] = value
    }
}

fun MutablePreferences.long(key: DataStoreKey, value: Long) {
    if (key.type == DataStoreKeyType.LONG) {
        this[key.longPreferenceKey()] = value
    }
}