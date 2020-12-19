package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TVShowsViewModelTest {

    private lateinit var viewModel: TVShowsViewModel

    @Before
    fun setUp() {
        viewModel = TVShowsViewModel()
    }

    @Test
    fun getTVShows() {
        val tvShows = viewModel.getTVShows()

        assertNotNull(tvShows)
        assertEquals(10, tvShows.size)
    }

    @Test
    fun notGetTVShows() {
        val tvShows = arrayListOf<TVShowEntity>()

        assertFalse(tvShows.isNotEmpty())
        assertNotEquals(10, tvShows.size)
    }
}