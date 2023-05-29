package com.beardness.yourchordsru.presentation.data.storage

import android.content.Context
import com.beardness.yourchordsru.presentation.data.storage.extensions.dataStore
import javax.inject.Inject

class AppDataStore @Inject constructor(
    context: Context,
) : AppDataStoreProtocol {

    private val dataStore = context.dataStore
}