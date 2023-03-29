package com.movieapp.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.movieapp.core.ui.screens.movie.movieRoute
import com.movieapp.core.ui.screens.moviedetails.movieDetailsRoute

@Composable
fun MovieNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MovieScreen.route) {
        movieRoute(navController)
        movieDetailsRoute(navController)
    }
}
