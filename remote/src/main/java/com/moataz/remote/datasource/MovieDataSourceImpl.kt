package com.moataz.remote.datasource

import com.moataz.data.datasource.MovieDataSource
import com.moataz.data.model.MovieDetailsModel
import com.moataz.data.model.MovieModel
import com.moataz.remote.MovieService
import com.moataz.remote.datasource.mapper.toMovieDetailsModel
import com.moataz.remote.datasource.mapper.toMovieListModel
import com.moataz.remote.datasource.utils.wrap
import com.moataz.remote.datasource.utils.wrapList
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieDataSource {

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
