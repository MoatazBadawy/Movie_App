package com.movieapp.core.viewmodels.uistate

data class MovieMainUIState(
    val movies: List<MovieUIState> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isSuccess: Boolean = false
)
