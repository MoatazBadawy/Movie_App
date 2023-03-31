package com.moataz.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moataz.local.entity.utils.EntityConstant.MOVIE_DETAILS_TABLE

@Entity(tableName = MOVIE_DETAILS_TABLE)
data class MovieDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val movieDetailsId: Int = 0,
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String,
)
