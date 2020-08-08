package com.example.movieshiltproject.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.movieshiltproject.model.MovieResponse
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.usecase.UseCase
import kotlinx.coroutines.launch

class TopRatedViewModel @ViewModelInject constructor(
    private val useCase: UseCase
) : ViewModel() {
    private var _topRatedMoviesList = MutableLiveData<Resource<MovieResponse>>()
    val topRatedMoviesList: LiveData<Resource<MovieResponse>>
        get() = _topRatedMoviesList

    fun getTopRatedMovies() = viewModelScope.launch {
        _topRatedMoviesList = liveData {
            emit(Resource.Loading())
            emit(useCase.getTopRatedMovies())
        } as MutableLiveData<Resource<MovieResponse>>
    }

}