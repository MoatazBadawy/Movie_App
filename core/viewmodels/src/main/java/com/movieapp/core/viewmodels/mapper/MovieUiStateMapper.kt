package com.movieapp.core.viewmodels.mapper

import com.movieapp.core.entities.Movie
import com.movieapp.core.viewmodels.BuildConfig
import com.movieapp.core.viewmodels.uistate.MovieDetailsUIState
import com.movieapp.core.viewmodels.uistate.MovieUIState

internal fun List<Movie>.toMovieUiStateList(): List<MovieUIState> {
    return map { it.toMovieUIState() }
}

internal fun Movie.toMovieUIState(): MovieUIState {
    return MovieUIState(
        id = id,
        posterPath = BuildConfig.IMAGE_BASE_PATH + posterPath,
        releaseDate = releaseDate,
    )
}

internal fun Movie.toMovieDetailsUIState(): MovieDetailsUIState {
    return MovieDetailsUIState(
        title = title,
        posterPath = BuildConfig.IMAGE_BASE_PATH + posterPath,
        releaseDate = releaseDate,
        overview = overview,
        voteAverage = voteAverage,
    )
}
