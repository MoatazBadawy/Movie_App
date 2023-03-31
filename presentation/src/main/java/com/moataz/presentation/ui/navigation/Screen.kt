package com.moataz.presentation.ui.navigation

sealed class Screen(val route: String) {
    object MovieScreen : Screen("movieScreen")
}
