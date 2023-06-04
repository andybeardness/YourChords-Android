package com.beardness.yourchordsru.presentation.view.screen.about

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class AboutScreenViewModel @Inject constructor(
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), AboutScreenViewModelProtocol {
}