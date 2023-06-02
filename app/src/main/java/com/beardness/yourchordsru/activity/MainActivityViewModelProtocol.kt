package com.beardness.yourchordsru.activity

import com.beardness.yourchordsru.presentation.domain.usecase.awake.AwakeState
import kotlinx.coroutines.flow.Flow

interface MainActivityViewModelProtocol {
    val awake: Flow<AwakeState>
    fun awake(value: Boolean)
}
