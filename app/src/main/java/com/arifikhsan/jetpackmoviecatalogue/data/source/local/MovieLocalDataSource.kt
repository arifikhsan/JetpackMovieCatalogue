package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.MovieDataSourceInterface
import com.google.gson.Gson
import java.io.InputStreamReader

class MovieLocalDataSource : MovieDataSourceInterface {
    override fun getMovies(): MutableLiveData<GetMoviesResponse?> {
        return MutableLiveData(
            Gson().fromJson(
                InputStreamReader(javaClass.getResourceAsStream("get_movies.json")),
                GetMoviesResponse::class.java
            )
        )
    }

    override fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
        return MutableLiveData(
            Gson().fromJson(
                InputStreamReader(javaClass.getResourceAsStream("get_movie.json")),
                GetMovieDetailResponse::class.java
            )
        )
    }

    override fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
        return MutableLiveData(
            Gson().fromJson(
                InputStreamReader(javaClass.getResourceAsStream("get_tv_shows.json")),
                GetTVShowsResponse::class.java
            )
        )
    }

    override fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
        return MutableLiveData(
            Gson().fromJson(
                InputStreamReader(javaClass.getResourceAsStream("get_tv_show.json")),
                GetTVShowDetailResponse::class.java
            )
        )
    }
}