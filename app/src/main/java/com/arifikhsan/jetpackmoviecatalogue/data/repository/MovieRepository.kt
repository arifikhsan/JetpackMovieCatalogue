package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import org.koin.java.KoinJavaComponent.inject

class MovieRepository(private val remoteRemoteDataSource: MovieRemoteDataSource) {

    fun getMovies(): MutableLiveData<GetMoviesResponse?> {
        return remoteRemoteDataSource.getMovies()
    }

    fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
        return remoteRemoteDataSource.getMovieDetail(id)
    }

//    fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
//        return remoteRemoteDataSource.getTVShows()
//    }
//
//    fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
//        return remoteRemoteDataSource.getTVShowDetail(id)
//    }
}