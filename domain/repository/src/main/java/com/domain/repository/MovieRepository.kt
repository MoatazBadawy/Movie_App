package com.domain.repository

import com.domain.entities.Movie
import com.domain.entities.MovieDetails

interface MovieRepository {
    suspend fun insertMostPopularMovies()
    suspend fun insertTopRatedMovies()
    suspend fun insertMovieDetails(movieId: Int)
    suspend fun getMostPopularMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getMovieDetails(movieId: Int): MovieDetails
}
