package com.moataz.movieapp.di

import com.moataz.data.repository.MovieRepositoryImpl
import com.moataz.domain.repository.MovieRepository
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
