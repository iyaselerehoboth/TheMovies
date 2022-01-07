package com.iyaselerehoboth.themovies.network

import com.iyaselerehoboth.themovies.network.response.DiscoverMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {

    @GET("discover/movie")
    suspend fun discoverMovies(@Query("api_key") apiKey: String): DiscoverMovieResponse


}