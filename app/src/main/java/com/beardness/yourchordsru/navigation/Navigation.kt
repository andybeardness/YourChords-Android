package com.beardness.yourchordsru.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.beardness.yourchordsru.presentation.screens.author.AuthorScreen
import com.beardness.yourchordsru.presentation.screens.author.AuthorScreenViewModel
import com.beardness.yourchordsru.presentation.screens.home.HomeScreen
import com.beardness.yourchordsru.presentation.screens.home.HomeScreenViewModel
import com.beardness.yourchordsru.presentation.screens.search.SearchScreen
import com.beardness.yourchordsru.presentation.screens.search.SearchScreenViewModel
import com.beardness.yourchordsru.presentation.screens.song.SongScreen
import com.beardness.yourchordsru.presentation.screens.song.SongScreenViewModel
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun Navigation(
    paddings: PaddingValues,
    setupNavController: (NavHostController) -> Unit
) {
    val navController = rememberNavController()
    setupNavController(navController)

    val argumentAuthorId = navArgument(
        name = "authorId",
        builder = { type = NavType.IntType }
    )

    val argumentSongId = navArgument(
        name = "songId",
        builder = { type = NavType.IntType }
    )

    NavHost(
        modifier = Modifier
            .padding(paddingValues = paddings),
        navController = navController,
        startDestination = "home",
    ) {
        composable(route = "home") {
            val viewModel = hiltViewModel<HomeScreenViewModel>()

            HomeScreen(
                viewModel = viewModel,
            )
        }

        composable(
            route = "author/{${argumentAuthorId.name}}",
            arguments = listOf(argumentAuthorId),
        ) { navBackStackEntry ->
            val viewModel = hiltViewModel<AuthorScreenViewModel>()

            val authorId =
                navBackStackEntry
                    .arguments
                    ?.getInt(argumentAuthorId.name)

            viewModel.load(authorId = authorId)

            AuthorScreen(
                viewModel = viewModel,
            )
        }

        composable(
            route = "song/{${argumentAuthorId.name}}/{${argumentSongId.name}}",
            arguments = listOf(argumentAuthorId, argumentSongId),
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

            val backgroundColor = YourChordsRuTheme.colors.background
            val textColor = YourChordsRuTheme.colors.text
            val chordsColor = YourChordsRuTheme.colors.blue

            viewModel.load(
                authorId = authorId,
                songId = songId,
                backgroundColor = backgroundColor,
                textColor = textColor,
                chordsColor = chordsColor,
            )

            SongScreen(
                viewModel = viewModel,
            )
        }
        
        composable(
            route = "search",
        ) {
            val viewModel = hiltViewModel<SearchScreenViewModel>()
            
            SearchScreen(viewModel = viewModel)
        }
    }
}