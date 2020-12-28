package com.arifikhsan.jetpackmoviecatalogue.data.source

import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse

interface MovieRemoteDataSourceInterface {
    fun getMovies(): GetMoviesResponse?
    fun getMovieDetail(id: Int): GetMovieDetailResponse?
    fun getTVShows(): GetTVShowsResponse?
    fun getTVShowDetail(it: Int): GetTVShowDetailResponse?
}