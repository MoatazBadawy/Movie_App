package com.moataz.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moataz.local.entity.MovieDetailsEntity
import com.moataz.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetails(movies: MovieDetailsEntity)

    @Query("SELECT * FROM MOVIES_TABLE WHERE type = :type")
    suspend fun getMoviesByType(type: String): List<MovieEntity>

    @Query("SELECT * FROM MOVIE_DETAILS_TABLE WHERE id = :id")
    suspend fun getMovieDetailsById(id: Int): MovieDetailsEntity
}
