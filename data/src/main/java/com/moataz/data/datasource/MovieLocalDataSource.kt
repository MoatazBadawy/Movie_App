package com.moataz.data.datasource

import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel

interface MovieLocalDataSource {
    suspend fun insertMostPopularMovies(movie: MovieModel)
    suspend fun insertTopRatedMovies(movie: MovieModel)
    suspend fun insertMovieDetailsById(movieDetails: MovieDetailsModel, movieId: Int)
    suspend fun getMoviesByType(type: String): List<MovieModel>
    suspend fun getMovieDetails(movieId: Int): MovieDetailsModel
}
