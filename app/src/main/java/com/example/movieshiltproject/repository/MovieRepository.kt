package com.example.movieshiltproject.repository

import com.example.movieshiltproject.api.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPopularMovies() = apiService.popularMovies()
    suspend fun getNowPlayingMovies() = apiService.nowPlayingMovies()
    suspend fun getUpcomingMovies() = apiService.upcomingMovies()
    suspend fun getTopRatedMovies() = apiService.topRatedMovies()
    suspend fun getMovieDetail(movieId:Int) = apiService.movieDetail(movieId)
}