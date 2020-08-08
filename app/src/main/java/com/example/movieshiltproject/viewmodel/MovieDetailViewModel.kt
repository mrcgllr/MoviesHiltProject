package com.example.movieshiltproject.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.movieshiltproject.model.Resource
import com.example.movieshiltproject.model.Result
import com.example.movieshiltproject.usecase.UseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel @ViewModelInject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private var _movieDetail = MutableLiveData<Resource<Result>>()
    val movieDetail: LiveData<Resource<Result>>
        get() = _movieDetail

    fun getMovieDetail(movieId: Int) = viewModelScope.launch {
        _movieDetail = liveData {
            emit(Resource.Loading())
            emit(useCase.getMovieDetail(movieId))
        } as MutableLiveData<Resource<Result>>
    }
}