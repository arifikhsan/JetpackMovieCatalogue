package com.arifikhsan.jetpackmoviecatalogue.data.source

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.ApiResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse

interface MovieDataSourceInterface {
    fun getMovies(): MutableLiveData<ApiResponse<GetMoviesResponse?>>
    fun getMovieDetail(id: Int): MutableLiveData<ApiResponse<GetMovieDetailResponse?>>
}