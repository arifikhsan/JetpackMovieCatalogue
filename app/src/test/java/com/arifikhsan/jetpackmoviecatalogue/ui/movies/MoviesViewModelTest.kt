package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val movies = viewModel.getMovies()

        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun notGetMovies() {
        val movies = arrayListOf<MovieEntity>()

        assertFalse(movies.isNotEmpty())
        assertNotEquals(10, movies.size)
    }
}