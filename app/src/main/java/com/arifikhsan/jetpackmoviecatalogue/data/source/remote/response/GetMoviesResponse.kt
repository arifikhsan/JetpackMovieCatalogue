package com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response

import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieResultsItem?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)

data class MovieResultsItem(

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("original_language")
    val originalLanguage: String? = null,

    @field:SerializedName("original_title")
    val originalTitle: String? = null,

    @field:SerializedName("video")
    val video: Boolean? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("genre_ids")
    val genreIds: List<Int?>? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("popularity")
    val popularity: Double? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null
) {
    companion object {
        fun fromMovieDetailResponse(movie: GetMovieDetailResponse?): MovieResultsItem {
            return MovieResultsItem(
                id = movie?.id ?: 0,
                title = movie?.title ?: "",
                overview = movie?.overview ?: "",
                popularity = movie?.popularity ?: 0.0,
                posterPath = movie?.posterPath ?: "",
                releaseDate = movie?.releaseDate ?: "",
                voteAverage = movie?.voteAverage ?: 0.0,
                voteCount = movie?.voteCount ?: 0,
            )
        }
    }
}
