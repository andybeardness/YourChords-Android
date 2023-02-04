package com.beardness.yourchordsru.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.beardness.yourchordsru.presentation.screens.author.AuthorScreen
import com.beardness.yourchordsru.presentation.screens.author.AuthorScreenViewModel
import com.beardness.yourchordsru.presentation.screens.home.HomeScreen
import com.beardness.yourchordsru.presentation.screens.home.HomeScreenViewModel
import com.beardness.yourchordsru.presentation.screens.song.SongScreen
import com.beardness.yourchordsru.presentation.screens.song.SongScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navigateToAuthor: (authorId: Int) -> Unit = { authorId ->
        navController.navigate(route = "author/$authorId")
    }

    val navigateToSong: (authorId: Int, songId: Int) -> Unit = {authorId, songId ->
        navController.navigate(route = "song/$authorId/$songId")
    }

    val argumentAuthorId = navArgument(
        name = "authorId",
        builder = { type = NavType.IntType }
    )

    val argumentSongId = navArgument(
        name = "songId",
        builder = { type = NavType.IntType }
    )

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable(route = "home") {
            val viewModel = hiltViewModel<HomeScreenViewModel>()

            HomeScreen(
                viewModel = viewModel,
                navigateToAuthor = navigateToAuthor,
            )
        }

        composable(
            route = "author/{${argumentAuthorId.name}}",
            arguments = listOf(argumentAuthorId)
        ) { navBackStackEntry ->
            val viewModel = hiltViewModel<AuthorScreenViewModel>()

            val authorId =
                navBackStackEntry
                    .arguments
                    ?.getInt(argumentAuthorId.name)

            viewModel.load(authorId = authorId)

            AuthorScreen(
                viewModel = viewModel,
                navigateToSong = navigateToSong,
            )
        }

        composable(
            route = "song/{${argumentAuthorId.name}}/{${argumentSongId.name}}",
            arguments = listOf(argumentAuthorId, argumentSongId)
        ) { navBackStackEntry ->
            val viewModel = hiltViewModel<SongScreenViewModel>()

            val authorId =
                navBackStackEntry
                    .arguments
                    ?.getInt(argumentAuthorId.name)

            val songId =
                navBackStackEntry
                    .arguments
                    ?.getInt(argumentSongId.name)

            viewModel.load(
                authorId = authorId,
                songId = songId,
            )

            SongScreen(
                viewModel = viewModel,
            )
        }
    }
}