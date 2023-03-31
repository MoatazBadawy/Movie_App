package com.moataz.movieapp.di

import com.moataz.data.datasource.MovieDataSource
import com.moataz.remote.datasource.MovieDataSourceImpl
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
