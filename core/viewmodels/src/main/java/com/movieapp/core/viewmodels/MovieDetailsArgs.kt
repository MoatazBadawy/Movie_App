package com.movieapp.core.viewmodels

import androidx.lifecycle.SavedStateHandle

class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {

    val movieId: Int = checkNotNull(savedStateHandle[MOVIE_ID]).toString().toInt()

    companion object {
        const val MOVIE_ID = "movie_id"
    }
}
