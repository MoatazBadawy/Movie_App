package com.movieapp.core.remote

import com.movieapp.core.remote.response.BaseResponse
import com.movieapp.core.repositories.models.MovieDetailsDto
import com.movieapp.core.repositories.models.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/popular")
    suspend fun getMostPopularMovies(): Response<BaseResponse<MovieDto>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<BaseResponse<MovieDto>>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): Response<MovieDetailsDto>
}
