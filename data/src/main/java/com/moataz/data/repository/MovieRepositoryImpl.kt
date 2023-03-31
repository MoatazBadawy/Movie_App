package com.moataz.data.repository

import com.moataz.data.datasource.MovieDataSource
import com.moataz.data.mapper.toMovie
import com.moataz.data.mapper.toMovieList
import com.moataz.domain.entity.MovieEntity
import com.moataz.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMostPopularMovies(): List<MovieEntity> {
        return movieDataSource.getMostPopularMovies().toMovieList()
    }

    override suspend fun getTopRatedMovies(): List<MovieEntity> {
        return movieDataSource.getTopRatedMovies().toMovieList()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieEntity {
        return movieDataSource.getMovieDetails(movieId).toMovie()
    }
}
