package com.domain.usecases

import com.domain.entities.Movie
import com.domain.repository.MovieRepository
import javax.inject.Inject

class GetMostPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(): List<Movie> {
        return movieRepository.getMostPopularMovies()
    }
}
