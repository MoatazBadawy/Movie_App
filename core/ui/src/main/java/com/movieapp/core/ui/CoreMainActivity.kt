package com.movieapp.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.movieapp.core.ui.screens.MovieScreen
import com.movieapp.core.ui.ui.theme.MovieAppTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoreMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTaskTheme {
                MovieScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTaskTheme {
        MovieScreen()
    }
}
