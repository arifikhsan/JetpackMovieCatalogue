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
        assertNotNull(localDataSource.getMovies().value)
    }

    @Test
    fun getMovie() {
        val movieId = localDataSource.getMovies().value?.results?.random()?.id!!
        assertNotNull(localDataSource.getMovieDetail(movieId).value)
    }

    @Test
    fun getTVShows() {
        assertNotNull(localDataSource.getTVShows().value)
    }

    @Test
    fun getTVShow() {
        val tvShowId = localDataSource.getTVShows().value?.results?.random()?.id!!
        assertNotNull(localDataSource.getTVShowDetail(tvShowId).value)
    }
}