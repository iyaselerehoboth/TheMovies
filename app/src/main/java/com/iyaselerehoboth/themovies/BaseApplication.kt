package com.iyaselerehoboth.themovies

import android.app.Application
import com.iyaselerehoboth.themovies.database.MovieDatabase
import com.iyaselerehoboth.themovies.database.repository.MovieRepository

class BaseApplication: Application() {

    val database by lazy { MovieDatabase.getDatabase(this) }
    val movieRepository by lazy{ MovieRepository(database.movieDao()) }
}