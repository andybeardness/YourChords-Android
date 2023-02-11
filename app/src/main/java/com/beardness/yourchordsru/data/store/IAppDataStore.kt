package com.beardness.yourchordsru.data.store

import com.beardness.yourchordsru.data.store.dto.ChordsViewDataStoreDto
import kotlinx.coroutines.flow.Flow

interface IAppDataStore {
    val isFirstLaunch: Flow<Boolean>
    val themeCode: Flow<Int>
    val chordsView: Flow<ChordsViewDataStoreDto>
    suspend fun setFirstLaunch()
    suspend fun setThemeCode(code: Int)
    suspend fun setBackgroundColor(color: Long)
    suspend fun setTextColor(color: Long)
    suspend fun setChordsColor(color: Long)
    suspend fun setFontSize(size: Int)
}