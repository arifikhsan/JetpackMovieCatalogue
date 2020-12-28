package com.arifikhsan.jetpackmoviecatalogue.network

import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getMovies(): Response<GetMoviesResponse>

    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") id: Int): Response<GetMovieDetailResponse>

    @GET("tv/popular")
    fun getTVShows(): Response<GetTVShowsResponse>

    @GET("tv/{id}")
    fun getTVShowDetail(@Path("id") id: Int): Response<GetTVShowDetailResponse>

}