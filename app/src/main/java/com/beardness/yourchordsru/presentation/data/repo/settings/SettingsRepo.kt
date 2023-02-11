package com.beardness.yourchordsru.presentation.data.repo.settings

import com.beardness.yourchordsru.data.store.IAppDataStore
import com.beardness.yourchordsru.presentation.data.repo.dto.repoDto
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepo @Inject constructor(
    private val appDataStore: IAppDataStore,
) : ISettingsRepo {

    override val chordsView =
        appDataStore
            .chordsView
            .map { chordsView -> chordsView.repoDto() }

    override suspend fun setupBackgroundColor(color: Long) {
        appDataStore.setBackgroundColor(color = color)
    }

    override suspend fun setupTextColor(color: Long) {
        appDataStore.setTextColor(color = color)
    }

    override suspend fun setupChordsColor(color: Long) {
        appDataStore.setChordsColor(color = color)
    }

    override suspend fun setupFontSize(size: Int) {
        appDataStore.setFontSize(size = size)
    }
}