package com.presentation.viewmodel.mapper

import com.domain.entities.Movie
import com.domain.entities.MovieDetails
import com.presentation.viewmodel.BuildConfig
import com.presentation.viewmodel.uimodels.MovieDetailsUI
import com.presentation.viewmodel.uimodels.MovieUI

internal fun List<Movie>.toMovieUIList(): List<MovieUI> {
    return map { it.toMovieUI() }
}

internal fun Movie.toMovieUI(): MovieUI {
    return MovieUI(
        id = id,
        posterPath = BuildConfig.IMAGE_BASE_PATH + posterPath,
    )
}

internal fun MovieDetails.toMovieDetailsUI(): MovieDetailsUI {
    return MovieDetailsUI(
        title = title,
        posterPath = BuildConfig.IMAGE_BASE_PATH + posterPath,
        releaseDate = releaseDate,
        overview = overview,
        voteAverage = voteAverage,
    )
}
