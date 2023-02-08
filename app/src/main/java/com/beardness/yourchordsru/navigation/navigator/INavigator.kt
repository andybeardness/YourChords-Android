package com.beardness.yourchordsru.navigation.navigator

import androidx.navigation.NavHostController

interface INavigator {
    fun setupNavController(controller: NavHostController)
    fun back()
    fun home()
    fun author(authorId: Int)
    fun song(authorId: Int, songId: Int)
    fun chords(authorId: Int, songId: Int)
    fun search()
}