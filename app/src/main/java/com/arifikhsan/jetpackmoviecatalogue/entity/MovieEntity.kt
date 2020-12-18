package com.arifikhsan.jetpackmoviecatalogue.entity

data class MovieEntity(
        val id: Int,
        val title: String,
        val overview: String,
        val popularity: Double,
        val posterPath: String,
        val releaseDate: String,
        val voteAverage: Double,
        val voteCount: Int
)