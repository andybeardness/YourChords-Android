package com.beardness.yourchordsru.activity

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.beardness.yourchordsru.activity.scaffold.IMainActivityViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), IMainActivityViewModel {

    override fun setupNavController(navHostController: NavHostController) {
        navigator.setupNavController(controller = navHostController)
    }

}