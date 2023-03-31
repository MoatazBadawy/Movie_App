package com.moataz.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moataz.local.dao.MovieDao
import com.moataz.local.entity.MovieDetailsEntity
import com.moataz.local.entity.MovieEntity

@Database(entities = [MovieEntity::class, MovieDetailsEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
