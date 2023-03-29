package com.movieapp.core.repositories

import com.movieapp.core.repositories.models.MovieDetailsDto
import com.movieapp.core.repositories.models.MovieDto

interface MovieDataSource {
    suspend fun getMostPopularMovies(): List<MovieDto>
    suspend fun getTopRatedMovies(): List<MovieDto>
    suspend fun getMovieDetails(movieId: Int): MovieDetailsDto
}
