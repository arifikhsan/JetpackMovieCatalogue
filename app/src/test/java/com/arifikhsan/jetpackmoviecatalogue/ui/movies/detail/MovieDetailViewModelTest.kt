package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.util.DataDummy
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {
    private val dataDummy = DataDummy()
    private lateinit var viewModel: MovieDetailViewModel
    private val sampleMovie = dataDummy.getMovie()
    private val sampleMovieId = sampleMovie.id!!

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>?>

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel(repository)
        viewModel.setMovieId(sampleMovieId)
    }

    @Test
    fun getMovie() {
        val movieEntity = MovieEntity.fromMovieResponse(sampleMovie)
        val movieResource = Resource.success(movieEntity)
        val movieLive = MutableLiveData<Resource<MovieEntity>>()
        movieLive.value = movieResource

        `when`(repository.getMovie(sampleMovieId)).thenReturn(movieLive)

        viewModel.movie.observeForever(observer)
        verify(observer).onChanged(movieResource)

        val movie = viewModel.movie.value?.data

        assertNotNull(movie)
        assertEquals(sampleMovie.id, movie?.id)
        assertEquals(sampleMovie.title, movie?.title)
        assertEquals(sampleMovie.overview, movie?.overview)
        assertEquals(sampleMovie.posterPath, movie?.posterPath)
        assertEquals(sampleMovie.releaseDate, movie?.releaseDate)
        assertEquals(sampleMovie.voteCount, movie?.voteCount)

        assertEquals(sampleMovie.popularity as Double, movie?.popularity as Double, 0.0001)
        assertEquals(sampleMovie.voteAverage as Double, movie.voteAverage as Double, 0.0001)
    }
}