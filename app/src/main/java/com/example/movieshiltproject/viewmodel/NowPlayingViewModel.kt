package com.example.movieshiltproject.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.movieshiltproject.model.MovieResponse
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.usecase.UseCase
import kotlinx.coroutines.launch

class NowPlayingViewModel @ViewModelInject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _nowPlayingMoviesList = MutableLiveData<Resource<MovieResponse>>()
    val nowPlayingMoviesList: LiveData<Resource<MovieResponse>>
        get() = _nowPlayingMoviesList


    fun getNowPlayingMovies() = viewModelScope.launch {
        _nowPlayingMoviesList = liveData {
            emit(Resource.Loading())
            emit(useCase.getNowPlayingMovies())
        } as MutableLiveData<Resource<MovieResponse>>


    }

}