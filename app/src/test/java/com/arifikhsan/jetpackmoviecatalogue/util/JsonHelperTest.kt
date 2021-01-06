package com.arifikhsan.jetpackmoviecatalogue.util

import org.junit.Test

import org.junit.Assert.*

class JsonHelperTest {

    private val jsonHelper = JsonHelper()

    @Test
    fun getMovies() {
        val movies = jsonHelper.getMovies()
        assertNotNull(movies)
    }

    @Test
    fun getMovie() {
    }

    @Test
    fun getTVShows() {
    }

    @Test
    fun getTVShow() {
    }
}