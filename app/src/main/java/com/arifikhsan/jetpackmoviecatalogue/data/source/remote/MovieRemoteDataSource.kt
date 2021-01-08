package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.MovieDataSourceInterface
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.RemoteHelper.call
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig

class MovieRemoteDataSource(private val networkConfig: NetworkConfig) : MovieDataSourceInterface {

    companion object {
        private val TAG = MovieRemoteDataSource::class.java.simpleName
    }

    override fun getMovies(): LiveData<ApiResponse<GetMoviesResponse>> {
        return call(networkConfig.getApiService().getMovies())
    }

    override fun getMovieDetail(id: Int): LiveData<ApiResponse<GetMovieDetailResponse>> {
        return call(networkConfig.getApiService().getMovieDetail(id))
    }
}