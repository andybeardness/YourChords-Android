package com.beardness.yourchordsru.app

import android.app.Application
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.startup.StartupUseCaseProtocol
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class YourChordsRuApp : Application() {

    @Inject
    lateinit var startupUseCase: StartupUseCaseProtocol

    @Inject
    @IoCoroutineScope
    lateinit var ioCoroutineScope: CoroutineScope

    override fun onCreate() {
        super.onCreate()
        loadAuthors()
    }

    private fun loadAuthors() {
        ioCoroutineScope.launch {
            startupUseCase.startup()
        }
    }
}