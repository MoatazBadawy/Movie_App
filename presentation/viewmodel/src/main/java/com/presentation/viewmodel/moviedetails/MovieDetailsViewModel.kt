package com.presentation.viewmodel.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecases.GetMovieDetailsUseCase
import com.presentation.viewmodel.mapper.toMovieDetailsUI
import com.presentation.viewmodel.uimodels.MovieDetailsUI
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

    private val _movieDetailsUiState = MutableStateFlow(MovieDetailsUIState())
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
                        movieDetails = getMovieDetailsUseCase(args.movieId).toMovieDetailsUI(),
                        isLoading = false,
                        isError = false,
                        isSuccess = true,
                    )
                }
            } catch (e: Exception) {
                _movieDetailsUiState.value = MovieDetailsUIState(
                    isError = true,
                    isLoading = false,
                    isSuccess = false,
                    movieDetails = MovieDetailsUI(),
                )
            }
        }
    }

    fun retryLoadDetails() {
        getMovieDetails()
    }
}
