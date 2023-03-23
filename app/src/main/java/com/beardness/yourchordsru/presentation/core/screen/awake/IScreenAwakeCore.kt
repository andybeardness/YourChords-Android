package com.beardness.yourchordsru.presentation.core.screen.awake

import kotlinx.coroutines.flow.StateFlow

interface IScreenAwakeCore {
    val screenAwakeFlow: StateFlow<Boolean>
    suspend fun makeScreenKeepAwake()
    suspend fun unmakeScreenKeepAwake()
}
