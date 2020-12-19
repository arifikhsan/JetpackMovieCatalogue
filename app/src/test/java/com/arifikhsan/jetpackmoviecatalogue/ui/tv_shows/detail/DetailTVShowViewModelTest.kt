package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.DetailMovieViewModel
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailTVShowViewModelTest {

    private lateinit var viewModel: DetailTVShowViewModel
    private val sampleTVShow = MovieRepository.getTVShows().first()
    private var tvShowId = sampleTVShow.id
    private val emptyTVShow = MovieRepository.getEmptyTVShow()

    @Before
    fun setUp() {
        viewModel = DetailTVShowViewModel()
        viewModel.setSelectedTVShow(tvShowId)
    }

    @Test
    fun getTVShow() {
        viewModel.setSelectedTVShow(sampleTVShow.id)
        val tvShow = viewModel.getTVShow()

        assertEquals(sampleTVShow.id, tvShow.id)
        assertEquals(sampleTVShow.name, tvShow.name)
        assertEquals(sampleTVShow.overview, tvShow.overview)
        assertEquals(sampleTVShow.popularity, tvShow.popularity, 0.0001)
        assertEquals(sampleTVShow.posterPath, tvShow.posterPath)
        assertEquals(sampleTVShow.firstAirDate, tvShow.firstAirDate)
        assertEquals(sampleTVShow.voteAverage, tvShow.voteAverage, 0.0001)
        assertEquals(sampleTVShow.voteCount, tvShow.voteCount)
    }

    @Test
    fun getEmptyTVShow() {
        viewModel.setSelectedTVShow(emptyTVShow.id)
        val tvShow = viewModel.getTVShow()

        assertNotNull(tvShow)
        assertEquals(emptyTVShow.id, tvShow.id)
        assertEquals(emptyTVShow.name, tvShow.name)
        assertEquals(emptyTVShow.overview, tvShow.overview)
        assertEquals(emptyTVShow.popularity, tvShow.popularity, 0.0001)
        assertEquals(emptyTVShow.posterPath, tvShow.posterPath)
        assertEquals(emptyTVShow.firstAirDate, tvShow.firstAirDate)
        assertEquals(emptyTVShow.voteAverage, tvShow.voteAverage, 0.0001)
        assertEquals(emptyTVShow.voteCount, tvShow.voteCount)
    }
}