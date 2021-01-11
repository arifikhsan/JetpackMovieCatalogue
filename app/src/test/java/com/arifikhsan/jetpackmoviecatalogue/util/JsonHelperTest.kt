package com.arifikhsan.jetpackmoviecatalogue.util

import com.arifikhsan.jetpackmoviecatalogue.injection.appModules
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class JsonHelperTest : KoinTest {

    private val jsonHelper by inject<JsonHelper>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(appModules)
    }

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