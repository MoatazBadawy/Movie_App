package com.moataz.domain.repository

import com.moataz.domain.entity.Movie
import com.moataz.domain.entity.MovieDetails

interface MovieRepository {
    suspend fun insertMostPopularMovies()
    suspend fun insertTopRatedMovies()
    suspend fun insertMovieDetails(movieId: Int)
    suspend fun getMostPopularMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getMovieDetails(movieId: Int): MovieDetails
}
