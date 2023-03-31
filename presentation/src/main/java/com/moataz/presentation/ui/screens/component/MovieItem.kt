package com.moataz.presentation.ui.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moataz.presentation.viewmodel.uimodels.MovieUI

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItem(
    movie: MovieUI,
    onClick: (movie: MovieUI) -> Unit,
) {
    Card(
        modifier = Modifier
            .height(160.dp)
            .fillMaxWidth()
            .padding(6.dp),
        elevation = 2.dp,
        onClick = { onClick(movie) },
    ) {
        Column {
            NetworkImage(url = movie.posterPath)
        }
    }
}
