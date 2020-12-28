package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val sampleMovie = MovieRepository.getMovies().first()
    private var movieId = sampleMovie.id

    private val emptyMovie = MovieRepository.getEmptyMovie()

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

    @Test
    fun getEmptyMovie() {
        viewModel.setSelectedMovie(emptyMovie.id)
        val movie = viewModel.getMovie()

        assertNotNull(movie)
        assertEquals(emptyMovie.id, movie.id)
        assertEquals(emptyMovie.title, movie.title)
        assertEquals(emptyMovie.overview, movie.overview)
        assertEquals(emptyMovie.popularity, movie.popularity, 0.0001)
        assertEquals(emptyMovie.posterPath, movie.posterPath)
        assertEquals(emptyMovie.releaseDate, movie.releaseDate)
        assertEquals(emptyMovie.voteAverage, movie.voteAverage, 0.0001)
        assertEquals(emptyMovie.voteCount, movie.voteCount)
    }
}