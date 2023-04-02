package com.data.repositories.repository

import com.data.repositories.datasource.MovieLocalDataSource
import com.data.repositories.datasource.MovieRemoteDataSource
import com.data.repositories.mapper.toMovieDetails
import com.data.repositories.mapper.toMovieList
import com.data.repositories.repository.utils.NetworkHelper
import com.domain.entities.Movie
import com.domain.entities.MovieDetails
import com.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val networkHelper: NetworkHelper,
) : MovieRepository {
    override suspend fun insertMostPopularMovies() {
        movieRemoteDataSource.getMostPopularMovies().map {
            movieLocalDataSource.insertMostPopularMovies(it)
        }
    }

    override suspend fun insertTopRatedMovies() {
        movieRemoteDataSource.getTopRatedMovies().map {
            movieLocalDataSource.insertTopRatedMovies(it)
        }
    }

    override suspend fun insertMovieDetails(movieId: Int) {
        movieLocalDataSource.insertMovieDetailsById(
            movieRemoteDataSource.getMovieDetails(movieId),
            movieId,
        )
    }

    override suspend fun getMostPopularMovies(): List<Movie> {
        return if (networkHelper.isInternetAvailable()) {
            insertMostPopularMovies()
            movieRemoteDataSource.getMostPopularMovies().toMovieList()
        } else {
            movieLocalDataSource.getMoviesByType("popular").toMovieList()
        }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return if (networkHelper.isInternetAvailable()) {
            insertTopRatedMovies()
            movieRemoteDataSource.getTopRatedMovies().toMovieList()
        } else {
            movieLocalDataSource.getMoviesByType("top_rated").toMovieList()
        }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        if (networkHelper.isInternetAvailable()) {
            insertMovieDetails(movieId)
        }
        return movieLocalDataSource.getMovieDetails(movieId).toMovieDetails()
    }
}
