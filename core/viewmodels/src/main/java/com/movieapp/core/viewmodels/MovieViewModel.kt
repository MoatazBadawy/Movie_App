package com.movieapp.core.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.core.usecases.movies.GetMostPopularMoviesUseCase
import com.movieapp.core.usecases.movies.GetTopRatedMoviesUseCase
import com.movieapp.core.viewmodels.mapper.toMovieUiStateList
import com.movieapp.core.viewmodels.uistate.MovieMainUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMostPopularMoviesUseCase: GetMostPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
) : ViewModel() {

    private val _movieUIState = MutableStateFlow(MovieMainUIState())
    val movieUIState get() = _movieUIState.asStateFlow()

    init {
        getMostPopularMovies()
    }

    private fun getMostPopularMovies() {
        viewModelScope.launch {
            try {
                _movieUIState.update {
                    it.copy(
                        movies = getMostPopularMoviesUseCase().toMovieUiStateList(),
                        isLoading = false,
                        isError = false,
                        isSuccess = true,
                    )
                }
            } catch (e: Exception) {
                _movieUIState.value = MovieMainUIState(
                    isError = true,
                    isLoading = false,
                    isSuccess = false,
                    movies = emptyList(),
                )
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                _movieUIState.update {
                    it.copy(
                        movies = getTopRatedMoviesUseCase().toMovieUiStateList(),
                        isLoading = false,
                        isError = false,
                        isSuccess = true,
                    )
                }
            } catch (e: Exception) {
                _movieUIState.value = MovieMainUIState(
                    isError = true,
                    isLoading = false,
                    isSuccess = false,
                    movies = emptyList(),
                )
            }
        }
    }
}
