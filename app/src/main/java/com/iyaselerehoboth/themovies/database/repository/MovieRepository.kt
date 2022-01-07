package com.iyaselerehoboth.themovies.database.repository

import com.iyaselerehoboth.themovies.database.dao.MovieDao
import com.iyaselerehoboth.themovies.database.entity.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {

    val allMovies: Flow<List<Movie>> = movieDao.getAll()

    suspend fun insert(movieList: List<Movie>){
        movieDao.insertMovieList(movieList)
    }
}