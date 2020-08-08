package com.example.movieshiltproject.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.movieshiltproject.model.MovieResponse
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.usecase.UseCase
import kotlinx.coroutines.launch

class UpcomingViewModel @ViewModelInject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _upcomingMovieList = MutableLiveData<Resource<MovieResponse>>()
    val upcomingMovieList: LiveData<Resource<MovieResponse>>
        get() = _upcomingMovieList

    fun getUpcomingMovies() = viewModelScope.launch {
        _upcomingMovieList = liveData {
            emit(Resource.Loading())
            emit(useCase.getUpcomingMovies())
        } as MutableLiveData<Resource<MovieResponse>>

    }
}