package com.beardness.yourchordsru.navigation.navigator

import androidx.navigation.NavHostController

interface INavigator {
    fun setup(controller: NavHostController)
    fun home()
    fun author(authorId: Int)
    fun song(authorId: Int, songId: Int)
}