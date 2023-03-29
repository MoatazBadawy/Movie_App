package com.moataz.movieapp.di

import com.movieapp.core.repositories.MovieRepositoryImpl
import com.movieapp.core.usecases.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @ViewModelScoped
    @Binds
    abstract fun bindUserRepository(
        userRepository: MovieRepositoryImpl,
    ): MovieRepository
}
