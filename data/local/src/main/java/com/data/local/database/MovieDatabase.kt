package com.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.local.dao.MovieDao
import com.data.local.entity.MovieDetailsEntity
import com.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class, MovieDetailsEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
