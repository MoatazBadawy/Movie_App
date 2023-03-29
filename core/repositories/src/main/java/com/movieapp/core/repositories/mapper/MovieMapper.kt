package com.movieapp.core.repositories.mapper

import com.movieapp.core.entities.Movie
import com.movieapp.core.repositories.models.MovieDetailsDto
import com.movieapp.core.repositories.models.MovieDto

internal fun List<MovieDto>.toMovieList(): List<Movie> {
    return map { it.toMovie() }
}

internal fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        title = title ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        backdropPath = backdropPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate ?: "",
    )
}

internal fun MovieDetailsDto.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        title = title ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        backdropPath = backdropPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate ?: "",
    )
}
