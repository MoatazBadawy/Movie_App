package com.presentation.ui.screens.movie

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.presentation.ui.navigation.Screen

fun NavGraphBuilder.movieRoute(navController: NavController) {
    composable(route = Screen.MovieScreen.route) {
        MovieScreen(navController)
    }
}
