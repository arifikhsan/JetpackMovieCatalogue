package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val sampleMovie = MovieRepository.getMovies().first()
    private var movieId = sampleMovie.id

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(sampleMovie.id)
        val movie = viewModel.getMovie()

        assertNotNull(movie)
        assertEquals(sampleMovie.id, movie.id)
        assertEquals(sampleMovie.title, movie.title)
        assertEquals(sampleMovie.overview, movie.overview)
        assertEquals(sampleMovie.popularity, movie.popularity, 0.0001)
        assertEquals(sampleMovie.posterPath, movie.posterPath)
        assertEquals(sampleMovie.releaseDate, movie.releaseDate)
        assertEquals(sampleMovie.voteAverage, movie.voteAverage, 0.0001)
        assertEquals(sampleMovie.voteCount, movie.voteCount)
    }
}