package com.data.repositories.datasource

import com.data.repositories.model.MovieDetailsModel
import com.data.repositories.model.MovieModel

interface MovieRemoteDataSource {
    suspend fun getMostPopularMovies(): List<MovieModel>
    suspend fun getTopRatedMovies(): List<MovieModel>
    suspend fun getMovieDetails(movieId: Int): MovieDetailsModel
}
