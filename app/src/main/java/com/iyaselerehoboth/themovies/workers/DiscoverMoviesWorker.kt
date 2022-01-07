package com.iyaselerehoboth.themovies.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.iyaselerehoboth.themovies.BaseApplication
import com.iyaselerehoboth.themovies.database.MovieDatabase
import com.iyaselerehoboth.themovies.database.repository.MovieRepository
import com.iyaselerehoboth.themovies.network.RetrofitClient
import com.iyaselerehoboth.themovies.network.TMDBApi

class DiscoverMoviesWorker(context: Context, parameters: WorkerParameters): CoroutineWorker(context, parameters) {

    override suspend fun doWork(): Result {
        val db = MovieDatabase.getDatabase(applicationContext)
        val tmdbApi = RetrofitClient.getInstance().create(TMDBApi::class.java)
        val movieRepository = MovieRepository(db.movieDao())

        return try{
            val response = tmdbApi.discoverMovies("a37d9263daa754a92b399b84ed002f7d")
            if(response != null){
                movieRepository.insert(response.results)
                Result.success()
            } else {
                Log.d("CHECK", "Response was null")
                Result.failure()
            }

        } catch (e: Exception){
            Log.d("CHECK", "Call failed with exception")
            Result.failure()
        }
    }
}