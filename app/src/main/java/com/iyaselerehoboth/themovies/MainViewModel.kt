package com.iyaselerehoboth.themovies

import androidx.lifecycle.*
import com.iyaselerehoboth.themovies.database.entity.Movie
import com.iyaselerehoboth.themovies.database.repository.MovieRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(private val movieRepository: MovieRepository): ViewModel() {

    val allMovies: LiveData<List<Movie>> = movieRepository.allMovies.asLiveData()

    fun insert(movieList: List<Movie>) = viewModelScope.launch {
        movieRepository.insert(movieList)
    }
}

class MainViewModelFactory(private val repository: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}