package com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.MovieResultsItem

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    val id: Int,

    val title: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    var favorite: Boolean = false
) {
    companion object {
        fun fromMoviesResponse(movies: GetMoviesResponse): List<MovieEntity>? {
            return movies.results?.map { fromMovieItem(it) }
        }

        fun fromMovieResponse(movie: GetMovieDetailResponse?): MovieEntity {
            return fromMovieItem(MovieResultsItem.fromMovieDetailResponse(movie))
        }

        private fun fromMovieItem(movie: MovieResultsItem?): MovieEntity {
            return MovieEntity(
                movie?.id ?: 0,
                movie?.title ?: "",
                movie?.overview ?: "",
                movie?.popularity ?: 0.0,
                movie?.posterPath ?: "",
                movie?.releaseDate ?: "",
                movie?.voteAverage ?: 0.0,
                movie?.voteCount ?: 0,
                false
            )
        }
    }
}