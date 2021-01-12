package com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetTVShowsResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<TVShowResultsItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)


data class TVShowResultsItem(

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("genre_ids")
	val genreIds: List<Int?>? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("origin_country")
	val originCountry: List<String?>? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("original_name")
	val originalName: String? = null,

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
) {
	companion object {
		fun fromTVShowDetailResponse(tvShow: GetTVShowDetailResponse?): TVShowResultsItem {
			return TVShowResultsItem(
                id = tvShow?.id ?: 0,
                name = tvShow?.name ?: "",
                overview = tvShow?.overview ?: "",
                popularity = tvShow?.popularity ?: 0.0,
                posterPath = tvShow?.posterPath ?: "",
                firstAirDate = tvShow?.firstAirDate ?: "",
                voteAverage = tvShow?.voteAverage ?: 0.0,
                voteCount = tvShow?.voteCount ?: 0,
            )
		}
	}
}