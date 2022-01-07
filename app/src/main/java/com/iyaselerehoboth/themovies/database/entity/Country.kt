package com.iyaselerehoboth.themovies.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
data class Country(
    @PrimaryKey @SerializedName("iso_3166_1") val iso3166: String,
    val name: String
)
