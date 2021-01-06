package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.util.AppExecutors

class MovieRepository(
    private val remote: MovieRemoteDataSource,
    private val local: MovieLocalDatasource,
    private val appExecutors: AppExecutors
) {

    fun getMovies(): MutableLiveData<GetMoviesResponse?> {
        return remote.getMovies()
    }

    fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
        return local.getMovieDetail(id)
    }

//    fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
//        return remoteRemoteDataSource.getTVShows()
//    }
//
//    fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
//        return remoteRemoteDataSource.getTVShowDetail(id)
//    }
}