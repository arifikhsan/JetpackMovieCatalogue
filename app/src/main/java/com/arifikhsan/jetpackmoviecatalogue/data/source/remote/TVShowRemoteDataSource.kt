package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.TVShowDatasourceInterface
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.RemoteHelper.call
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig

class TVShowRemoteDataSource(private val networkConfig: NetworkConfig) : TVShowDatasourceInterface {

    companion object {
        private val TAG = TVShowRemoteDataSource::class.java.simpleName
    }

    override fun getTVShows(): LiveData<ApiResponse<GetTVShowsResponse>> {
        return call(networkConfig.getApiService().getTVShows())
    }

    override fun getTVShowDetail(id: Int): LiveData<ApiResponse<GetTVShowDetailResponse>> {
        return call(networkConfig.getApiService().getTVShowDetail(id))
    }
}