package com.data.remote.datasource.mapper

import com.data.remote.dto.MovieDetailsDto
import com.data.remote.dto.MovieDto
import com.data.repositories.model.MovieDetailsModel
import com.data.repositories.model.MovieModel

internal fun List<MovieDto>.toMovieListModel(): List<MovieModel> {
    return map { it.toMovieModel() }
}

internal fun MovieDto.toMovieModel() = MovieModel(
    id = id,
    posterPath = posterPath,
)

internal fun MovieDetailsDto.toMovieDetailsModel() = MovieDetailsModel(
    title = title,
    posterPath = posterPath,
    overview = overview,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
)
