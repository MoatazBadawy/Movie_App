package com.moataz.movieapp.di

import com.moataz.data.datasource.MovieLocalDataSource
import com.moataz.data.datasource.MovieRemoteDataSource
import com.moataz.local.datasource.MovieLocalDataSourceImpl
import com.moataz.remote.datasource.MovieRemoteDataSourceImpl
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
