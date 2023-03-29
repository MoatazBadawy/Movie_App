package com.movieapp.core.usecases.repository

import com.movieapp.core.entities.Movie

interface MovieRepository {
    suspend fun getMostPopularMovies(): List<Movie>
    suspend fun getTopRatedMovies(): List<Movie>
    suspend fun getMovieDetails(movieId: Int): Movie
}
