package com.presentation.viewmodel.movies

import com.presentation.viewmodel.uimodels.MovieUI

data class MovieUIState(
    val movies: List<MovieUI> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
)
