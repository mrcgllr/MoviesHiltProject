package com.example.movieshiltproject.di

import com.example.movieshiltproject.repository.MovieRepository
import com.example.movieshiltproject.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun provideUseCase(dataRepository: MovieRepository): UseCase {
        return UseCase(dataRepository)
    }
}