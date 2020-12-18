package com.arifikhsan.jetpackmoviecatalogue.entity

data class TVShowEntity (
        val id: Int,
        val name: String,
        val overview: String,
        val popularity: Double,
        val posterPath: String,
        val firstAirDate: String,
        val voteAverage: Double,
        val voteCount: Int
)