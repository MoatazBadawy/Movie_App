package com.movieapp.core.repositories.movie

import com.movieapp.core.repositories.models.MovieDto

interface MovieDataSource {
    suspend fun getMostPopularMovies(): List<MovieDto>
    suspend fun getTopRatedMovies(): List<MovieDto>
}
