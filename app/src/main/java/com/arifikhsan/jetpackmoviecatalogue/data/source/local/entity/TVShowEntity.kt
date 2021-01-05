package com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_shows")
data class TVShowEntity(
    @PrimaryKey
    @NonNull
    val id: Int,

    val name: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val firstAirDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    var favorite: Boolean = false
)