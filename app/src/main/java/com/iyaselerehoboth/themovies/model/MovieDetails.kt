package com.iyaselerehoboth.themovies.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import com.iyaselerehoboth.themovies.database.entity.Company
import com.iyaselerehoboth.themovies.database.entity.Country
import com.iyaselerehoboth.themovies.database.entity.Genre
import com.iyaselerehoboth.themovies.database.entity.Language


data class MovieDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("adult") @ColumnInfo(name = "adult") val adult: Boolean,
    @SerializedName("backdrop_path") @ColumnInfo(name = "backdrop_path") val backdropPath: String?,
    @SerializedName("belongs_to_collection") @ColumnInfo(name = "belongs_to_collection") val belongsToCollection: String?,
    val budget: Double?,
    val genres: List<Genre>,
    val homepage: String?,
    @SerializedName("imdb_id") @ColumnInfo(name = "imdb_id") val imdbId: String,
    @SerializedName("original_language") @ColumnInfo(name = "original_language") val originalLanguage: String,
    @SerializedName("original_title") @ColumnInfo(name = "original_title") val originalTitle: String,
    val overview: String,
    val popularity: Double?,
    @SerializedName("production_companies") @ColumnInfo(name = "production_companies") val productionCompanies: List<Company>,
    @SerializedName("production_countries") @ColumnInfo(name = "production_countries") val productionCountries: List<Country>,
    @SerializedName("release_date") @ColumnInfo(name = "release_date") val releaseDate: String,
    val revenue: Double,
    val runtime: Int,
    @SerializedName("spoken_languages") @ColumnInfo(name = "spoken_languages") val spokenLanguages: List<Language>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average") @ColumnInfo(name = "vote_average") val voteAverage: Double,
    @SerializedName("vote_count") @ColumnInfo(name = "vote_count") val voteCount: Int
)
