package com.data.remote.datasource

import com.data.remote.MovieService
import com.data.remote.datasource.mapper.toMovieDetailsModel
import com.data.remote.datasource.mapper.toMovieListModel
import com.data.remote.datasource.utils.wrap
import com.data.repositories.datasource.MovieRemoteDataSource
import com.data.repositories.model.MovieDetailsModel
import com.data.repositories.model.MovieModel
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRemoteDataSource {

    override suspend fun getMostPopularMovies(): List<MovieModel> {
        return wrap { movieService.getMostPopularMovies() }.items?.toMovieListModel() ?: emptyList()
    }

    override suspend fun getTopRatedMovies(): List<MovieModel> {
        return wrap { movieService.getTopRatedMovies() }.items?.toMovieListModel() ?: emptyList()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsModel {
        return wrap { movieService.getMovieDetails(movieId) }.toMovieDetailsModel()
    }
}
