package com.arifikhsan.jetpackmoviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.ApiResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse

interface TVShowDatasourceInterface {
    fun getTVShows(): LiveData<ApiResponse<GetTVShowsResponse>>
    fun getTVShowDetail(id: Int): LiveData<ApiResponse<GetTVShowDetailResponse>>
}