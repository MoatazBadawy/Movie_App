package com.data.repositories.mapper

import com.data.repositories.model.MovieDetailsModel
import com.data.repositories.model.MovieModel
import com.domain.entities.Movie
import com.domain.entities.MovieDetails

internal fun List<MovieModel>.toMovieList(): List<Movie> {
    return map { it.toMovie() }
}

internal fun MovieModel.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        posterPath = posterPath ?: "",
    )
}

internal fun MovieDetailsModel.toMovieDetails(): MovieDetails {
    return MovieDetails(
        title = title ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate ?: "",
    )
}
