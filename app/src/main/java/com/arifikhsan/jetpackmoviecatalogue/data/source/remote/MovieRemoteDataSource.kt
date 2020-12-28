package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.MovieRemoteDataSourceInterface
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig

class MovieRemoteDataSource(private val networkConfig: NetworkConfig) :
    MovieRemoteDataSourceInterface {

    override fun getMovies(): GetMoviesResponse? {
        return networkConfig.getApiService().getMovies().body()
    }

    override fun getMovieDetail(id: Int): GetMovieDetailResponse? {
        return networkConfig.getApiService().getMovieDetail(id).body()
    }

    override fun getTVShows(): GetTVShowsResponse? {
        return networkConfig.getApiService().getTVShows().body()
    }

    override fun getTVShowDetail(id: Int): GetTVShowDetailResponse? {
        return networkConfig.getApiService().getTVShowDetail(id).body()
    }
}