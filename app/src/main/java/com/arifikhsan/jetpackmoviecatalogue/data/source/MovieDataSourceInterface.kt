package com.arifikhsan.jetpackmoviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.ApiResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse

interface MovieDataSourceInterface {
    fun getMovies(): LiveData<ApiResponse<GetMoviesResponse>>
    fun getMovieDetail(id: Int): LiveData<ApiResponse<GetMovieDetailResponse>>
}