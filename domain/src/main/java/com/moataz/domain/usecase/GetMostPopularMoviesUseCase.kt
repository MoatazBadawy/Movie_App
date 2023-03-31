package com.moataz.domain.usecase

import com.moataz.domain.entity.Movie
import com.moataz.domain.repository.MovieRepository
import javax.inject.Inject

class GetMostPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(): List<Movie> {
        return movieRepository.getMostPopularMovies()
    }
}