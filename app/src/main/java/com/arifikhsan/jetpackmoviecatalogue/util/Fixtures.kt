package com.arifikhsan.jetpackmoviecatalogue.util

import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class Fixtures {
    fun getMovies(): GetMoviesResponse {
        val testFolderResources = File(File("").absolutePath, "src/test/resources")
        val jsonFile = File(testFolderResources.absolutePath, "get_movies.json")
        val iStream = FileInputStream(jsonFile)

        val iReader = InputStreamReader(iStream)
        val data = Gson().fromJson(iReader, GetMoviesResponse::class.java)

        iReader.close()
        iStream.close()

        return data
    }
}