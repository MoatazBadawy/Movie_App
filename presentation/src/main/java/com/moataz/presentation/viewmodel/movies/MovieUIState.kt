package com.moataz.presentation.viewmodel.movies

import com.moataz.presentation.viewmodel.uimodels.MovieUI

data class MovieUIState(
    val movies: List<MovieUI> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
)
