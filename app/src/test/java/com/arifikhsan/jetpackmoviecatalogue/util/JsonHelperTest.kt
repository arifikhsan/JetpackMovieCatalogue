package com.arifikhsan.jetpackmoviecatalogue.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class JsonHelperTest {

    private val jsonHelper = JsonHelper()

    @Test
    fun getMovies() {
        val movies = jsonHelper.getMovies()

        assertNotNull(movies)
        assertEquals(20, movies.results?.size)
    }

    @Test
    fun getMovie() {
        assertNotNull(jsonHelper.getMovie())
    }

    @Test
    fun getTVShows() {
        val tvShows = jsonHelper.getTVShows()

        assertNotNull(tvShows)
        assertEquals(20, tvShows.results?.size)
    }

    @Test
    fun getTVShow() {
        assertNotNull(jsonHelper.getTVShows())
    }
}