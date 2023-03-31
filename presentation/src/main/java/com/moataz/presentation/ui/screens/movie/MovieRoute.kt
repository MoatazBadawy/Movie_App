package com.moataz.presentation.ui.screens.movie

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.moataz.presentation.ui.navigation.Screen

fun NavGraphBuilder.movieRoute(navController: NavController) {
    composable(route = Screen.MovieScreen.route) {
        MovieScreen(navController)
    }
}
