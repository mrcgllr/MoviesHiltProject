package com.example.movieshiltproject.api

import com.example.movieshiltproject.model.MovieResponse
import com.example.movieshiltproject.model.Result
import com.example.movieshiltproject.util.Constant.URL_GET_DETAIL_MOVIE
import com.example.movieshiltproject.util.Constant.URL_GET_NOW_PLAYING_MOVIES
import com.example.movieshiltproject.util.Constant.URL_GET_POPULAR_MOVIES
import com.example.movieshiltproject.util.Constant.URL_GET_TOP_RATED
import com.example.movieshiltproject.util.Constant.URL_GET_UPCOMING
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(URL_GET_POPULAR_MOVIES)
    suspend fun popularMovies(): MovieResponse

    @GET(URL_GET_NOW_PLAYING_MOVIES)
    suspend fun nowPlayingMovies(): MovieResponse

    @GET(URL_GET_UPCOMING)
    suspend fun upcomingMovies(): MovieResponse

    @GET(URL_GET_TOP_RATED)
    suspend fun topRatedMovies(): MovieResponse

    @GET(URL_GET_DETAIL_MOVIE)
    suspend fun movieDetail(@Path("movie_id") movieId: Int): Result

}