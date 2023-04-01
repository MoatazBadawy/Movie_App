package com.moataz.local.datasource

import com.moataz.data.datasource.MovieLocalDataSource
import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel
import com.moataz.local.dao.MovieDao
import com.moataz.local.datasource.mapper.toMovieDetailsEntity
import com.moataz.local.datasource.mapper.toMovieDetailsModel
import com.moataz.local.datasource.mapper.toMovieEntity
import com.moataz.local.datasource.mapper.toMovieListModel
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
