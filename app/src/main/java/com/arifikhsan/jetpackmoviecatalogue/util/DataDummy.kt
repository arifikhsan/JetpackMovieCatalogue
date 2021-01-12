package com.arifikhsan.jetpackmoviecatalogue.util

import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class DataDummy {
    fun getMovies(): GetMoviesResponse {
        return getFromJson("get_movies.json", GetMoviesResponse::class.java)
    }

    fun getMovie(): GetMovieDetailResponse {
        return getFromJson("get_movie.json", GetMovieDetailResponse::class.java)
    }

    fun getTVShows(): GetTVShowsResponse {
        return getFromJson("get_tv_shows.json", GetTVShowsResponse::class.java)
    }

    fun getTVShow(): GetTVShowDetailResponse {
        return getFromJson("get_tv_show.json", GetTVShowDetailResponse::class.java)
    }

    private fun <T> getFromJson(filename: String, type: Class<T>): T {
        val testFolderResources = File(File("").absolutePath, "src/test/resources")
        val jsonFile = File(testFolderResources.absolutePath, filename)
        val iStream = FileInputStream(jsonFile)

        val iReader = InputStreamReader(iStream)
        val data = Gson().fromJson(iReader, type)

        iReader.close()
        iStream.close()

        return data
    }
}