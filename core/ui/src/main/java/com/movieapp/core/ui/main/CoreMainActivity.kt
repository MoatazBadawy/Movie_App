package com.movieapp.core.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.movieapp.core.ui.navigation.MovieNavGraph
import com.movieapp.core.ui.ui.theme.MovieAppTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoreMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTaskTheme {
                MovieNavGraph()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTaskTheme {
        MovieNavGraph()
    }
}
