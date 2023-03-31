package com.moataz.data.mapper

import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel
import com.moataz.domain.entity.MovieEntity

internal fun List<MovieModel>.toMovieList(): List<MovieEntity> {
    return map { it.toMovie() }
}

internal fun MovieModel.toMovie(): MovieEntity {
    return MovieEntity(
        id = id ?: 0,
        title = title ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        backdropPath = backdropPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate ?: "",
    )
}

internal fun MovieDetailsModel.toMovie(): MovieEntity {
    return MovieEntity(
        id = id ?: 0,
        title = title ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        backdropPath = backdropPath ?: "",
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate ?: "",
    )
}
