package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.TVShowDatasourceInterface
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.RemoteHelper.call
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.network.NetworkService
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse

class TVShowRemoteDataSource(private val apiService: NetworkService) : TVShowDatasourceInterface {

    override fun getTVShows(): LiveData<ApiResponse<GetTVShowsResponse>> {
        return call(apiService.getTVShows())
    }

    override fun getTVShowDetail(id: Int): LiveData<ApiResponse<GetTVShowDetailResponse>> {
        return call(apiService.getTVShow(id))
    }
}