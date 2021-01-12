package com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.TVShowResultsItem

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
) {
    companion object {
        fun fromTVShowsResponse(tvShows: GetTVShowsResponse): List<TVShowEntity>? {
            return tvShows.results?.map { fromTVShowItem(it) }
        }

        fun fromTVShowResponse(tvShow: GetTVShowDetailResponse?): TVShowEntity {
            return fromTVShowItem(TVShowResultsItem.fromTVShowDetailResponse(tvShow))
        }

        private fun fromTVShowItem(tvShow: TVShowResultsItem?): TVShowEntity {
            return TVShowEntity(
                tvShow?.id ?: 0,
                tvShow?.name ?: "",
                tvShow?.overview ?: "",
                tvShow?.popularity ?: 0.0,
                tvShow?.posterPath ?: "",
                tvShow?.firstAirDate ?: "",
                tvShow?.voteAverage ?: 0.0,
                tvShow?.voteCount ?: 0,
                false
            )
        }
    }
}