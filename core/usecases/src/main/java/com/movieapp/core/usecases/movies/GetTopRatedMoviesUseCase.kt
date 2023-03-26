package com.movieapp.core.usecases.movies

import com.movieapp.core.entities.Movie
import com.movieapp.core.usecases.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(): List<Movie> {
        return movieRepository.getTopRatedMovies()
    }
}
