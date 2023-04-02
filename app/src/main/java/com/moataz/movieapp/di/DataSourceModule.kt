package com.moataz.movieapp.di

import com.data.local.datasource.MovieLocalDataSourceImpl
import com.data.remote.datasource.MovieRemoteDataSourceImpl
import com.data.repositories.datasource.MovieLocalDataSource
import com.data.repositories.datasource.MovieRemoteDataSource
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
        remoteDataSource: MovieRemoteDataSourceImpl,
    ): MovieRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(
        localDataSource: MovieLocalDataSourceImpl,
    ): MovieLocalDataSource
}
