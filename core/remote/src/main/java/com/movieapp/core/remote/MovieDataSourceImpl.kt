package com.movieapp.core.remote

import com.movieapp.core.remote.response.BaseResponse
import com.movieapp.core.repositories.models.MovieDto
import com.movieapp.core.repositories.movie.MovieDataSource
import retrofit2.Response
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieDataSource {

    override suspend fun getMostPopularMovies(): List<MovieDto> {
        return wrap { movieService.getMostPopularMovies() }
    }

    override suspend fun getTopRatedMovies(): List<MovieDto> {
        return wrap { movieService.getTopRatedMovies() }
    }

    private suspend fun <T : Any> wrap(function: suspend () -> Response<BaseResponse<T>>): List<T> {
        val response = function()
        return if (response.isSuccessful) {
            when (response.code()) {
                200 -> response.body()?.items
                else -> throw Throwable(response.errorBody().toString())
            } as List<T>
        } else {
            throw Throwable("Network Error")
        }
    }
}
