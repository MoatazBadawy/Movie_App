package com.moataz.presentation.ui.screens.moviedetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.moataz.presentation.viewmodel.moviedetails.MovieDetailsArgs

const val MOVIE_DETAILS_SCREEN = "movieDetailsScreenWithId"

fun NavController.navigateToMovieDetails(movieId: Int) {
    navigate("$MOVIE_DETAILS_SCREEN/$movieId")
}

fun NavGraphBuilder.movieDetailsRoute(navController: NavController) {
    composable(
        route = "$MOVIE_DETAILS_SCREEN/{${MovieDetailsArgs.MOVIE_ID}}",
        arguments = listOf(
            navArgument(MovieDetailsArgs.MOVIE_ID) { NavType.IntType },
        ),
    ) {
        MovieDetailsScreen(navController)
    }
}
