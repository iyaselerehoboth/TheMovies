package com.iyaselerehoboth.themovies.network.response

import com.iyaselerehoboth.themovies.database.entity.Movie

class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
) {
}