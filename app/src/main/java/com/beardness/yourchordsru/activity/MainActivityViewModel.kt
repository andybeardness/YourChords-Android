package com.beardness.yourchordsru.activity

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel() {

}