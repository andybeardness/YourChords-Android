package com.beardness.yourchordsru.presentation.domain.usecase.awake

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class AwakeUseCase @Inject constructor(
) : AwakeUseCaseProtocol {

    private val _awake = MutableStateFlow<AwakeState>(value = AwakeState.DEFAULT)
    override val awake = _awake.asStateFlow()

    override suspend fun makeAwake(value: Boolean) {
        val state = if (value) AwakeState.AWAKE else AwakeState.DEFAULT
        _awake.emit(value = state)
    }
}