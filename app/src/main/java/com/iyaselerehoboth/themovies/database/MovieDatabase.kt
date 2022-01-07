package com.iyaselerehoboth.themovies.database

import android.content.Context
import androidx.room.*
import com.iyaselerehoboth.themovies.database.converter.GenreConverter
import com.iyaselerehoboth.themovies.database.dao.MovieDao
import com.iyaselerehoboth.themovies.database.entity.*
import com.iyaselerehoboth.themovies.model.MovieDetails

@Database(entities = [Movie::class, Company::class, Country::class, Genre::class, Language::class], version = 1, exportSchema = false)
@TypeConverters(GenreConverter::class)
public abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object{

        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            //If the INSTANCE is not null, then return it else create a new instance
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movieDb"
                ).build()

                INSTANCE = instance

                //return instance
                instance
            }
        }
    }

}