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
    title = title,
    posterPath = posterPath,
    backdropPath = backdropPath,
    overview = overview,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
    popularity = popularity,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    genreIds = genreIds,
    video = video,
    adult = adult,
)

internal fun MovieDetailsDto.toMovieDetailsModel() = MovieDetailsModel(
    id = id,
    title = title,
    posterPath = posterPath,
    backdropPath = backdropPath,
    overview = overview,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
    popularity = popularity,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    video = video,
    adult = adult,
    budget = budget,
    homepage = homepage,
    imdbId = imdbId,
    revenue = revenue,
    runtime = runtime,
    status = status,
    tagline = tagline,
)
