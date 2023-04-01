package com.moataz.data.mapper

import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel
import com.moataz.domain.entity.Movie
import com.moataz.domain.entity.MovieDetails

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
