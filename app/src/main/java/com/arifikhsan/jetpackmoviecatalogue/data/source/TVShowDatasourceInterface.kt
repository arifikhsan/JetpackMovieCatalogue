package com.arifikhsan.jetpackmoviecatalogue.data.source

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.ApiResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse

interface TVShowDatasourceInterface {
    fun getTVShows(): MutableLiveData<ApiResponse<GetTVShowsResponse?>>
    fun getTVShowDetail(id: Int): MutableLiveData<ApiResponse<GetTVShowDetailResponse?>>
}