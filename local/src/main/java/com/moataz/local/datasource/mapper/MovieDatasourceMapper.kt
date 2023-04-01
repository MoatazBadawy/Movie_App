package com.moataz.local.datasource.mapper

import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel
import com.moataz.local.entity.MovieDetailsEntity
import com.moataz.local.entity.MovieEntity

internal fun List<MovieEntity>.toMovieListModel(): List<MovieModel> {
    return map { it.toMovieModel() }
}

internal fun MovieEntity.toMovieModel() = MovieModel(
    id = id,
    posterPath = posterPath,
)

internal fun MovieDetailsEntity.toMovieDetailsModel() = MovieDetailsModel(
    title = title,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage,
    releaseDate = releaseDate,
)

internal fun MovieModel.toMovieEntity(type: String) = MovieEntity(
    id = id ?: 0,
    posterPath = posterPath ?: "",
    type = type,
)

internal fun MovieDetailsModel.toMovieDetailsEntity(id: Int) = MovieDetailsEntity(
    id = id,
    title = title ?: "",
    overview = overview ?: "",
    posterPath = posterPath ?: "",
    voteAverage = voteAverage ?: 0.0,
    releaseDate = releaseDate ?: "",
)
