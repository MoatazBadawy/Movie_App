package com.moataz.data.datasource

import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel

interface MovieDataSource {
    suspend fun getMostPopularMovies(): List<MovieModel>
    suspend fun getTopRatedMovies(): List<MovieModel>
    suspend fun getMovieDetails(movieId: Int): MovieDetailsModel
}
