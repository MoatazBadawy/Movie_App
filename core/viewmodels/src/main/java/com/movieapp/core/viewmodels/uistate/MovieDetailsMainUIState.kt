package com.movieapp.core.viewmodels.uistate

data class MovieDetailsMainUIState(
    val movieDetails: MovieDetailsUIState = MovieDetailsUIState(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
)
