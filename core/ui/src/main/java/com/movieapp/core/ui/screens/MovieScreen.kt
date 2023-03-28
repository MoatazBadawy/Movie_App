package com.movieapp.core.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.movieapp.core.ui.component.Loading
import com.movieapp.core.ui.component.MovieItem
import com.movieapp.core.ui.component.MovieToolbar
import com.movieapp.core.viewmodels.MovieViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel(),
) {
    val movieUiState by viewModel.movieUiState.collectAsState()
    val selectedSortType by viewModel.selectedSortType.collectAsState()
    val showDropdown by viewModel.showDropdown.collectAsState()

    Scaffold(
        topBar = {
            MovieToolbar(
                title = selectedSortType.title,
                sortType = selectedSortType,
                onSortSelected = viewModel::setSelectedSortType,
                showDropdown = showDropdown,
                onDropdownShown = viewModel::setShowDropdown,
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                when {
                    movieUiState.isLoading -> Loading()

                    movieUiState.isSuccess && movieUiState.movies.isNotEmpty() -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        ) {
                            items(movieUiState.movies) { movie ->
                                MovieItem(movie = movie)
                            }
                        }
                    }

                    movieUiState.isError && movieUiState.movies.isEmpty() -> {
                        Snackbar(
                            modifier = Modifier.padding(16.dp).align(Alignment.BottomEnd),
                            action = {
                                TextButton(onClick = viewModel::retry) {
                                    Text(
                                        text = "Retry",
                                        color = Color.White,
                                    )
                                }
                            },
                        ) {
                            Text(
                                text = "Failed to load movies",
                                color = Color.White,
                            )
                        }
                    }
                }
            }
        },
    )
}
