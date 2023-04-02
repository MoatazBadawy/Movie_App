package com.domain.usecases

import com.domain.entities.MovieDetails
import com.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(movieId: Int): MovieDetails {
        return movieRepository.getMovieDetails(movieId)
    }
}
