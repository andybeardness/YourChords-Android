package com.beardness.yourchordsru.presentation.core.screen.awake

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScreenAwakeCore: IScreenAwakeCore {
    private val _screenAwakeFlow = MutableStateFlow<Boolean>(value = false)
    override val screenAwakeFlow: StateFlow<Boolean> = _screenAwakeFlow.asStateFlow()

    override suspend fun makeScreenKeepAwake() {
        _screenAwakeFlow.emit(value = true)
    }

    override suspend fun unmakeScreenKeepAwake() {
        _screenAwakeFlow.emit(value = false)
    }
}