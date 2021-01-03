package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MovieLocalDataSourceTest {

    private lateinit var localDataSource: MovieLocalDataSource

    @Before
    fun setUp() {
        localDataSource = MovieLocalDataSource()
    }

    @Test
    fun getMovies() {
        assertNotNull(localDataSource.getMovies())
    }

    @Test
    fun getMovie() {
        assertNotNull(localDataSource.getMovieDetail())
    }

    @Test
    fun getTVShows() {
        assertNotNull(localDataSource.getTVShows())
    }

    @Test
    fun getTVShow() {
        assertNotNull(localDataSource.getTVShowDetail())
    }
}