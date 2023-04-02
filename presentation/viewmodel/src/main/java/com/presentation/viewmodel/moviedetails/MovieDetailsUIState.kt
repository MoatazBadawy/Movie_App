package com.presentation.viewmodel.moviedetails

import com.presentation.viewmodel.uimodels.MovieDetailsUI

data class MovieDetailsUIState(
    val movieDetails: MovieDetailsUI = MovieDetailsUI(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
)
