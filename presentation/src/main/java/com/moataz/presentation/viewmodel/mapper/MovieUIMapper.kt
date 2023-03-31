package com.moataz.presentation.viewmodel.mapper

import com.moataz.domain.entity.MovieEntity
import com.moataz.presentation.BuildConfig
import com.moataz.presentation.viewmodel.uimodels.MovieDetailsUI
import com.moataz.presentation.viewmodel.uimodels.MovieUI

internal fun List<MovieEntity>.toMovieUIList(): List<MovieUI> {
    return map { it.toMovieUI() }
}

internal fun MovieEntity.toMovieUI(): MovieUI {
    return MovieUI(
        id = id,
        posterPath = BuildConfig.IMAGE_BASE_PATH + posterPath,
        releaseDate = releaseDate,
    )
}

internal fun MovieEntity.toMovieDetailsUI(): MovieDetailsUI {
    return MovieDetailsUI(
        title = title,
        posterPath = BuildConfig.IMAGE_BASE_PATH + posterPath,
        releaseDate = releaseDate,
        overview = overview,
        voteAverage = voteAverage,
    )
}
