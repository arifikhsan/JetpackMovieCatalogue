package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource

class MovieRepository(private val remoteDataSource: MovieRemoteDataSource) {
    fun getMovies(): MutableLiveData<GetMoviesResponse?> {
        return remoteDataSource.getMovies()
    }

    fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
        return remoteDataSource.getMovieDetail(id)
    }

    fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
        return remoteDataSource.getTVShows()
    }

    fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
        return remoteDataSource.getTVShowDetail(id)
    }
}