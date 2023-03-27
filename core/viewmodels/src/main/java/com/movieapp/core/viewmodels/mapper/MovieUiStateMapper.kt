package com.movieapp.core.viewmodels.mapper

import com.movieapp.core.entities.Movie
import com.movieapp.core.viewmodels.uistate.MovieUIState

internal fun List<Movie>.toMovieUiStateList(): List<MovieUIState> {
    return map { it.toMovieUIState() }
}

internal fun Movie.toMovieUIState(): MovieUIState {
    return MovieUIState(
        id = id,
        posterPath = posterPath,
        releaseDate = releaseDate,
    )
}
