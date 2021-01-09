package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.TVShowDatasourceInterface
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.RemoteHelper.call
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.network.NetworkConfig

class TVShowRemoteDataSource(private val networkConfig: NetworkConfig) : TVShowDatasourceInterface {

    override fun getTVShows(): LiveData<ApiResponse<GetTVShowsResponse>> {
        return call(networkConfig.getApiService().getTVShows())
    }

    override fun getTVShowDetail(id: Int): LiveData<ApiResponse<GetTVShowDetailResponse>> {
        return call(networkConfig.getApiService().getTVShowDetail(id))
    }
}