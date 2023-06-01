package com.beardness.yourchordsru.presentation.data.storage

import kotlinx.coroutines.flow.Flow

interface AppDataStoreProtocol {

    val fontSize: Flow<Int?>
    val viewMode: Flow<Int?>

    suspend fun fontSize(): Int?
    suspend fun viewModeCode(): Int?

    suspend fun updateFontSize(update: Int)
    suspend fun updateViewMode(update: Int)
}