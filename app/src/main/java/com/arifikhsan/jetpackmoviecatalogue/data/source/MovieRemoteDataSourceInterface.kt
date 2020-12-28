package com.arifikhsan.jetpackmoviecatalogue.data.source

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse

interface MovieRemoteDataSourceInterface {
    fun getMovies(): MutableLiveData<GetMoviesResponse?>
    fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?>
    fun getTVShows(): MutableLiveData<GetTVShowsResponse?>
    fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?>
}