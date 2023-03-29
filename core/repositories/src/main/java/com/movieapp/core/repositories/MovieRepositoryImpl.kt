package com.movieapp.core.repositories

import com.movieapp.core.entities.Movie
import com.movieapp.core.repositories.mapper.toMovie
import com.movieapp.core.repositories.mapper.toMovieList
import com.movieapp.core.usecases.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMostPopularMovies(): List<Movie> {
        return movieDataSource.getMostPopularMovies().toMovieList()
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return movieDataSource.getTopRatedMovies().toMovieList()
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return movieDataSource.getMovieDetails(movieId).toMovie()
    }
}
