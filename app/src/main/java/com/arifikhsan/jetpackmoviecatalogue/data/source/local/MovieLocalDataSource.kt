package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import com.google.gson.Gson
import java.io.InputStreamReader

class MovieLocalDataSource {
    fun getMovies(): GetMoviesResponse {
        return Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_movies.json")),
            GetMoviesResponse::class.java
        )
    }

    fun getMovieDetail(): GetMovieDetailResponse {
        return Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_movie.json")),
            GetMovieDetailResponse::class.java
        )
    }

//    fun getRandomMovieDetail(): MovieResultsItem {
//        val movies = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_movies.json")),
//            GetMoviesResponse::class.java
//        )
//
//        return movies.results.random()
//    }

    fun getTVShows(): GetTVShowsResponse {
        return Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_tv_shows.json")),
            GetTVShowsResponse::class.java
        )
    }

    fun getTVShowDetail(): GetTVShowDetailResponse {
        return Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_tv_show.json")),
            GetTVShowDetailResponse::class.java
        )

    }
}