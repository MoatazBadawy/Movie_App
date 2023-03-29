package com.movieapp.core.ui.screens.moviedetails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.movieapp.core.ui.component.Loading
import com.movieapp.core.viewmodels.MovieDetailsViewModel
import com.movieapp.core.viewmodels.uistate.MovieDetailsUIState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
) {
    val movieDetailsUIState by viewModel.movieDetailsUiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            movieDetailsUIState.isLoading -> Loading()

            movieDetailsUIState.isSuccess -> MovieDetailsContent(
                navController = navController,
                movieDetailsUIState = movieDetailsUIState.movieDetails,
            )

            movieDetailsUIState.isError -> {
                Snackbar(
                    modifier = Modifier.padding(16.dp).align(Alignment.BottomEnd),
                    action = {
                        TextButton(onClick = viewModel::retryLoadDetails) {
                            Text(
                                text = "Retry",
                                color = Color.White,
                            )
                        }
                    },
                ) {
                    Text(
                        text = "Failed to load Movie Details",
                        color = Color.White,
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailsContent(
    movieDetailsUIState: MovieDetailsUIState,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movie Details",
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(movieDetailsUIState.posterPath),
                contentDescription = movieDetailsUIState.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movieDetailsUIState.title,
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RatingBar(
                    rating = movieDetailsUIState.voteAverage.toFloat(),
                    modifier = Modifier.width(120.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = movieDetailsUIState.releaseDate,
                    style = MaterialTheme.typography.body1,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Overview",
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movieDetailsUIState.overview,
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Composable
fun RatingBar(rating: Float, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(16.dp),
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$rating/10",
            style = MaterialTheme.typography.body1,
        )
    }
}
