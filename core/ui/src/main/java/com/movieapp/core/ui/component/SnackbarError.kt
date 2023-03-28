package com.movieapp.core.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorSnackBar(
    message: String,
    onClick: () -> Unit,
) {
    Box(modifier = Modifier.padding(16.dp)) {
        Snackbar(
            modifier = Modifier.fillMaxSize()
                .align(Alignment.BottomEnd),
            action = {
                TextButton(onClick = onClick) {
                    Text(
                        text = "Retry",
                        color = Color.White,
                    )
                }
            },
        ) {
            Text(
                text = message,
                color = Color.White,
            )
        }
    }
}
