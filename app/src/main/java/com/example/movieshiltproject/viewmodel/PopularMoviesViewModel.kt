package com.example.movieshiltproject.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.movieshiltproject.model.MovieResponse
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.usecase.UseCase
import kotlinx.coroutines.launch

class PopularMoviesViewModel @ViewModelInject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _popularMoviesList = MutableLiveData<Resource<MovieResponse>>()
    val popularMoviesList: LiveData<Resource<MovieResponse>>
        get() = _popularMoviesList


    fun getPopularMovies() = viewModelScope.launch {
        _popularMoviesList = liveData {
            emit(Resource.Loading())
            emit(useCase.getPopularMovies())
        } as MutableLiveData<Resource<MovieResponse>>
    }
}