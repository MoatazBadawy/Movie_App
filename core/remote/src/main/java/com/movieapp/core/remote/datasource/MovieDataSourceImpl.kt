package com.movieapp.core.remote.datasource

import com.movieapp.core.remote.MovieService
import com.movieapp.core.remote.datasource.utils.wrap
import com.movieapp.core.remote.datasource.utils.wrapList
import com.movieapp.core.repositories.models.MovieDetailsDto
import com.movieapp.core.repositories.models.MovieDto
import com.movieapp.core.repositories.MovieDataSource
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieDataSource {

    override suspend fun getMostPopularMovies(): List<MovieDto> {
        return wrapList { movieService.getMostPopularMovies() }
    }

    override suspend fun getTopRatedMovies(): List<MovieDto> {
        return wrapList { movieService.getTopRatedMovies() }
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsDto {
        return wrap { movieService.getMovieDetails(movieId) }
    }
}
