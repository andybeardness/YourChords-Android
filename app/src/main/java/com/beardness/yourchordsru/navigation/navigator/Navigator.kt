package com.beardness.yourchordsru.navigation.navigator

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import javax.inject.Inject

class Navigator @Inject constructor(): INavigator {

    private var _navHostController: NavController? = null

    override fun setupNavController(controller: NavHostController) {
        _navHostController = controller
    }

    override fun back() {
        _navHostController?.popBackStack()
    }

    override fun home() {
        _navHostController?.navigate(route = "home") {
            popUpTo(id = 0)
        }
    }

    override fun author(authorId: Int) {
        _navHostController?.navigate(route = "author/$authorId")
    }

    override fun song(authorId: Int, songId: Int) {
        _navHostController?.navigate(route = "song/$authorId/$songId")
    }

    override fun search() {
        _navHostController?.navigate(route = "search")
    }
}