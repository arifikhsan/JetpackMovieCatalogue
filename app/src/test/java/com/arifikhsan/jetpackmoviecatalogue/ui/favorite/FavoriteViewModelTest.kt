package com.arifikhsan.jetpackmoviecatalogue.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verifyNoInteractions
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: FavoriteViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var tvShowRepository: TVShowRepository

    @Mock
    private lateinit var observer: Observer<Int>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieRepository, tvShowRepository)
    }

    @Test
    fun getFavoriteMoviesCount() {
        val numberLive = MutableLiveData<Int>()
        val numberRandom = (0 until 100).random()
        numberLive.value = numberRandom
        `when`(movieRepository.getFavoriteMoviesCount()).thenReturn(numberLive)

        val count = viewModel.getFavoriteMoviesCount().value
        verify(movieRepository).getFavoriteMoviesCount()
        verifyNoInteractions(tvShowRepository)
        assertNotNull(count)
        assertEquals(numberRandom, count)

        viewModel.getFavoriteMoviesCount().observeForever(observer)
        verify(observer).onChanged(numberRandom)
    }

    @Test
    fun getFavoriteTVShowsCount() {
        val numberLive = MutableLiveData<Int>()
        val numberRandom = (0 until 100).random()
        numberLive.value = numberRandom
        `when`(tvShowRepository.getFavoriteTVShowsCount()).thenReturn(numberLive)

        val count = viewModel.getFavoriteTVShowsCount().value
        verify(tvShowRepository).getFavoriteTVShowsCount()
        verifyNoInteractions(movieRepository)
        assertNotNull(count)
        assertEquals(numberRandom, count)

        viewModel.getFavoriteTVShowsCount().observeForever(observer)
        verify(observer).onChanged(numberRandom)
    }
}