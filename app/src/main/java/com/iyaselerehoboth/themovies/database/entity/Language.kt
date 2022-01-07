package com.iyaselerehoboth.themovies.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "language")
data class Language(
    @PrimaryKey val name: String,
    @SerializedName("english_name") @ColumnInfo(name = "english_name") val englishName: String,
    @SerializedName("iso_639_1") val iso639: String
)
