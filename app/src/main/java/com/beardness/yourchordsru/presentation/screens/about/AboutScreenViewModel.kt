package com.beardness.yourchordsru.presentation.screens.about

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.data.store.IAppDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AboutScreenViewModel @Inject constructor(
    private val dataStore: IAppDataStore,
) : ViewModel() {
    val themeCode: Flow<Int?> = dataStore.themeCode
    val backgroundColor: Flow<Long?> = dataStore.backgroundColor
    val textColor: Flow<Long?> = dataStore.textColor
    val chordsColor: Flow<Long?> = dataStore.chordsColor
    val fontSize: Flow<Int?> = dataStore.fontSize
    val songSortTypeCode: Flow<Int?> = dataStore.songSortTypeCode
}