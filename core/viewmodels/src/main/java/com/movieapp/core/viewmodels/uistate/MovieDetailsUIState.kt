package com.movieapp.core.viewmodels.uistate

data class MovieDetailsUIState(
    val title: String = "",
    val posterPath: String = "",
    val releaseDate: String = "",
    val overview: String = "",
    val voteAverage: Double = 0.0,
)
