package com.data.remote.datasource

import com.data.remote.MovieService
import com.data.remote.datasource.mapper.toMovieDetailsModel
import com.data.remote.datasource.mapper.toMovieListModel
import com.data.remote.datasource.utils.wrap
import com.data.remote.datasource.utils.wrapList
import com.data.repositories.datasource.MovieRemoteDataSource
import com.data.repositories.model.MovieDetailsModel
import com.data.repositories.model.MovieModel
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRemoteDataSource {

    override suspend fun getMostPopularMovies(): List<MovieModel> {
        return wrapList { movieService.getMostPopularMovies() }.toMovieListModel()
    }

    override suspend fun getTopRatedMovies(): List<MovieModel> {
        return wrapList { movieService.getTopRatedMovies() }.toMovieListModel()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsModel {
        return wrap { movieService.getMovieDetails(movieId) }.toMovieDetailsModel()
    }
}
