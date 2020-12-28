package com.arifikhsan.jetpackmoviecatalogue.data.source

import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse

interface MovieRemoteDataSourceInterface {
    fun getMovies(): GetMoviesResponse?
    fun getMovieDetail(id: Int): GetMovieDetailResponse?
    fun getTVShows(): GetTVShowsResponse?
    fun getTVShowDetail(id: Int): GetTVShowDetailResponse?
}