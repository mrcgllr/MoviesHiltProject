package com.example.movieshiltproject.di

import com.example.movieshiltproject.api.ApiService
import com.example.movieshiltproject.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun provideRepository(apiService: ApiService): MovieRepository {
        return MovieRepository(apiService)
    }
}