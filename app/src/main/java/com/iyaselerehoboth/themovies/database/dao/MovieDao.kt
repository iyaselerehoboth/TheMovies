package com.iyaselerehoboth.themovies.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iyaselerehoboth.themovies.database.entity.Movie
import com.iyaselerehoboth.themovies.model.MovieDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(list: List<Movie>)

    @Query("SELECT * FROM movie")
    fun getAll(): Flow<List<Movie>>
}