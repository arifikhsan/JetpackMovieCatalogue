package com.arifikhsan.jetpackmoviecatalogue.util

import org.junit.Test

import org.junit.Assert.*

class FixturesTest {

    @Test
    fun getMovies() {
        val movies = Fixtures().getMovies()

        assertNotNull(movies)
        assertEquals(20, movies.results?.size)
    }
}