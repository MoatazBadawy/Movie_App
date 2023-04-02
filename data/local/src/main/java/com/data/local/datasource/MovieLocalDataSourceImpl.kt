package com.data.local.datasource

import com.data.local.dao.MovieDao
import com.data.local.datasource.mapper.toMovieDetailsEntity
import com.data.local.datasource.mapper.toMovieDetailsModel
import com.data.local.datasource.mapper.toMovieEntity
import com.data.local.datasource.mapper.toMovieListModel
import com.data.repositories.datasource.MovieLocalDataSource
import com.data.repositories.model.MovieDetailsModel
import com.data.repositories.model.MovieModel
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
) : MovieLocalDataSource {
    override suspend fun insertMostPopularMovies(movie: MovieModel) {
        movieDao.insertMovie(movie.toMovieEntity(type = "popular"))
    }

    override suspend fun insertTopRatedMovies(movie: MovieModel) {
        movieDao.insertMovie(movie.toMovieEntity(type = "top_rated"))
    }

    override suspend fun insertMovieDetailsById(movieDetails: MovieDetailsModel, movieId: Int) {
        movieDao.insertMovieDetails(movieDetails.toMovieDetailsEntity(movieId))
    }

    override suspend fun getMoviesByType(type: String): List<MovieModel> {
        return movieDao.getMoviesByType(type).toMovieListModel()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsModel {
        return movieDao.getMovieDetailsById(movieId).toMovieDetailsModel()
    }
}
