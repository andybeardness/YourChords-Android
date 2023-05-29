package com.beardness.yourchordsru.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.beardness.yourchordsru.presentation.view.screen.author.AuthorScreenViewModel
import com.beardness.yourchordsru.presentation.view.screen.author.AuthorsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navigateBack: () -> Unit = {
        navController.navigateUp()
    }

    val navigateSongs: (authorId: Int) -> Unit = { authorId ->
        navController.navigate(route = "songs/${authorId}")
    }

    val navigateChords: (authorId: Int, songId: Int) -> Unit = { authorId, songId ->
        navController.navigate(route = "chords/$authorId/$songId")
    }

    val navigateSearch: () -> Unit = {
        navController.navigate(route = "search")
    }

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = "authors",
    ) {
        composable(
            route = "authors",
        ) {
            val viewModel = hiltViewModel<AuthorScreenViewModel>()

            AuthorsScreen(
                viewModel = viewModel,
                navigateToSongs = navigateSongs,
                navigateToSearch = navigateSearch,
            )
        }

        composable(
            route = "songs/{authorId}",
            arguments = listOf(
                navArgument(name = "authorId") { type = NavType.IntType },
            ),
        ) {

        }

        composable(
            route = "chords/{authorId}/{songId}", arguments = listOf(
                navArgument(name = "authorId") { type = NavType.IntType },
                navArgument(name = "songId") { type = NavType.IntType },
            )
        ) {

        }

        composable(
            route = "search",
        ) {

        }
    }
}