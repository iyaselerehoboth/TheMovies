package com.iyaselerehoboth.themovies.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "company")
data class Company(
    @PrimaryKey val id: Int,
    @SerializedName("logo_path") @ColumnInfo(name = "logo_path") val logoPath: String,
    val name: String,
    @SerializedName("origin_country") @ColumnInfo(name = "origin_country") val originCountry: String
)