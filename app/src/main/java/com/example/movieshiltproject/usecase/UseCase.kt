package com.example.movieshiltproject.usecase

import com.example.movieshiltproject.model.MovieResponse
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.model.Result
import com.example.movieshiltproject.repository.MovieRepository
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: MovieRepository) {

    suspend fun getPopularMovies(): Resource<MovieResponse> {
        val popularMovies = repository.getPopularMovies()

        return if (!popularMovies.results.isNullOrEmpty()) {
            Resource.Success(popularMovies)
        } else {
            Resource.Failed("Something error.")
        }
    }

    suspend fun getNowPlayingMovies(): Resource<MovieResponse> {
        val nowPlayingMovies = repository.getNowPlayingMovies()

        return if (!nowPlayingMovies.results.isNullOrEmpty()) {
            Resource.Success(nowPlayingMovies)
        } else {
            Resource.Failed("Something error.")
        }
    }

    suspend fun getUpcomingMovies(): Resource<MovieResponse> {
        val upcomingMovies = repository.getUpcomingMovies()

        return if (!upcomingMovies.results.isNullOrEmpty()) {
            Resource.Success(upcomingMovies)
        } else {
            Resource.Failed("Something error.")
        }
    }

    suspend fun getTopRatedMovies(): Resource<MovieResponse> {
        val topRatedMovies = repository.getTopRatedMovies()

        return if (!topRatedMovies.results.isNullOrEmpty()) {
            Resource.Success(topRatedMovies)
        } else {
            Resource.Failed("Something error.")
        }
    }

    suspend fun getMovieDetail(movieId: Int): Resource<Result> {
        val movieDetail = repository.getMovieDetail(movieId)

        return if (movieDetail != null) {
            Resource.Success(movieDetail)
        } else {
            Resource.Failed("Something error.")
        }
    }
}