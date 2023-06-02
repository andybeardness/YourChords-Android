package com.beardness.yourchordsru.activity

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.awake.AwakeUseCaseProtocol
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val awakeUseCase: AwakeUseCaseProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), MainActivityViewModelProtocol {

    override val awake = awakeUseCase.awake

    override fun awake(value: Boolean) {
        ioCoroutineScope.launch {
            awakeUseCase.makeAwake(value = value)
        }
    }
}