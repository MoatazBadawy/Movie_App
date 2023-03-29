package com.moataz.movieapp.ui.di

import com.movieapp.core.remote.datasource.MovieDataSourceImpl
import com.movieapp.core.repositories.MovieDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSource: MovieDataSourceImpl,
    ): MovieDataSource
}
