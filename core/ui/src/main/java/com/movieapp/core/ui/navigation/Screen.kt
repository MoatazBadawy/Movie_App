package com.movieapp.core.ui.navigation

sealed class Screen(val route: String) {
    object MovieScreen : Screen("movieScreen")
}
