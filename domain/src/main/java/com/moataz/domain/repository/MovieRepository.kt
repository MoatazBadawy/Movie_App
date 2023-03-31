package com.moataz.domain.repository

import com.moataz.domain.entity.MovieEntity

interface MovieRepository {
    suspend fun getMostPopularMovies(): List<MovieEntity>
    suspend fun getTopRatedMovies(): List<MovieEntity>
    suspend fun getMovieDetails(movieId: Int): MovieEntity
}
