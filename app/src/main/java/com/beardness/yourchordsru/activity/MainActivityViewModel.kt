package com.beardness.yourchordsru.activity

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.beardness.yourchordsru.activity.scaffold.IMainActivityViewModel
import com.beardness.yourchordsru.navigation.navigator.INavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val navigator: INavigator,
): ViewModel(), IMainActivityViewModel {

    override fun setupNavController(navHostController: NavHostController) {
        navigator.setupNavController(controller = navHostController)
    }

}