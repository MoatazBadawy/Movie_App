package com.moataz.remote.datasource.mapper

import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel
import com.moataz.remote.dto.MovieDetailsDto
import com.moataz.remote.dto.MovieDto

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
