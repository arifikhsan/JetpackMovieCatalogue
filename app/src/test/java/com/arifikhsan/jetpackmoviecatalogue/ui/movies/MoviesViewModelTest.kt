package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.InputStreamReader

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(repository)
    }

    @Test
    fun getMovies() {
        val sampleMovies = Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_movies.json")),
            GetMoviesResponse::class.java
        )
        `when`(repository.getMovies()).thenReturn(MutableLiveData(sampleMovies))
        viewModel.getMovies()

        assertNotNull(sampleMovies)
        assertNotNull(viewModel.movies)
        assertEquals(sampleMovies, viewModel.movies.value)
        assertEquals(sampleMovies.results?.size, viewModel.movies.value?.results?.size)
    }
}