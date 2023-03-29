package com.movieapp.core.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.core.usecases.GetMovieDetailsUseCase
import com.movieapp.core.viewmodels.mapper.toMovieDetailsUIState
import com.movieapp.core.viewmodels.uistate.MovieDetailsMainUIState
import com.movieapp.core.viewmodels.uistate.MovieDetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _movieDetailsUiState = MutableStateFlow(MovieDetailsMainUIState())
    val movieDetailsUiState get() = _movieDetailsUiState.asStateFlow()

    private val args = MovieDetailsArgs(savedStateHandle)

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            try {
                _movieDetailsUiState.update {
                    it.copy(
                        movieDetails = getMovieDetailsUseCase(args.movieId).toMovieDetailsUIState(),
                        isLoading = false,
                        isError = false,
                        isSuccess = true,
                    )
                }
            } catch (e: Exception) {
                _movieDetailsUiState.value = MovieDetailsMainUIState(
                    isError = true,
                    isLoading = false,
                    isSuccess = false,
                    movieDetails = MovieDetailsUIState(),
                )
            }
        }
    }

    fun retryLoadDetails() {
        getMovieDetails()
    }
}
