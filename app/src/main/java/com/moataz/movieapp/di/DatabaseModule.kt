package com.moataz.movieapp.di

import android.content.Context
import androidx.room.Room
import com.data.local.dao.MovieDao
import com.data.local.database.MovieDatabase
import com.moataz.movieapp.di.utils.DatabaseConstant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): MovieDatabase {
        return Room.databaseBuilder(
            appContext,
            MovieDatabase::class.java,
            DATABASE_NAME,
        ).build()
    }

    @Singleton
    @Provides
    fun provideHabitDao(database: MovieDatabase): MovieDao {
        return database.movieDao()
    }
}
