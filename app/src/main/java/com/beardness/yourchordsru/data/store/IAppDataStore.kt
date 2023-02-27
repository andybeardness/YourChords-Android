package com.beardness.yourchordsru.data.store

import kotlinx.coroutines.flow.Flow

interface IAppDataStore {
    val themeCode: Flow<Int>
    val backgroundColor: Flow<Long>
    val textColor: Flow<Long>
    val chordsColor: Flow<Long>
    val fontSize: Flow<Int>
    val authorSortTypeCode: Flow<Int>
    val songSortTypeCode: Flow<Int>
    suspend fun setThemeCode(code: Int)
    suspend fun setBackgroundColor(color: Long)
    suspend fun setTextColor(color: Long)
    suspend fun setChordsColor(color: Long)
    suspend fun setFontSize(size: Int)
    suspend fun setAuthorsSortType(code: Int)
    suspend fun setSongsSortType(code: Int)
}