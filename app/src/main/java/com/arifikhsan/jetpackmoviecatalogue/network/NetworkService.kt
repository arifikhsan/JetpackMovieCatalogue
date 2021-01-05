package com.arifikhsan.jetpackmoviecatalogue.network

import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getMovies(): Call<GetMoviesResponse>

    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") id: Int): Call<GetMovieDetailResponse>

    @GET("tv/popular")
    fun getTVShows(): Call<GetTVShowsResponse>

    @GET("tv/{id}")
    fun getTVShowDetail(@Path("id") id: Int): Call<GetTVShowDetailResponse>

}