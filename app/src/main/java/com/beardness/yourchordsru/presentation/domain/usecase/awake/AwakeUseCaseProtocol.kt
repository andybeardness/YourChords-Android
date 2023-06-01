package com.beardness.yourchordsru.presentation.domain.usecase.awake

import kotlinx.coroutines.flow.StateFlow

interface AwakeUseCaseProtocol {
    val awake: StateFlow<AwakeState>
    suspend fun makeAwake(value: Boolean)
}
