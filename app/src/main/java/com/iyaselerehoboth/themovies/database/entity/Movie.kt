package com.iyaselerehoboth.themovies.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.iyaselerehoboth.themovies.database.converter.GenreConverter

@Entity(tableName = "movie")
@TypeConverters(GenreConverter::class)
data class Movie(
    @PrimaryKey val id: Int,
    @SerializedName("poster_path") @ColumnInfo(name = "poster_path") val posterPath: String?,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date") @ColumnInfo(name = "release_date") val releaseDate: String?,
    //@SerializedName("genre_ids") @ColumnInfo(name = "genre_ids") val genreIds: List<Genre>,
    @SerializedName("original_language") @ColumnInfo(name = "original_language") val originalLanguage: String,
    @SerializedName("original_title") @ColumnInfo(name = "original_title") val originalTitle: String,
    val popularity: Double?,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average") @ColumnInfo(name = "vote_average") val voteAverage: Double,
) {
}