package com.iyaselerehoboth.themovies.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.iyaselerehoboth.themovies.database.entity.Genre

class GenreConverter {
    @TypeConverter
    fun listToJson(value: List<Genre>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Genre::class.java)
}