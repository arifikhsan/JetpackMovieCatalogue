package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.ErrorNotFoundResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import com.google.gson.Gson
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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

    @Mock
    private lateinit var dataSource: MovieRemoteDataSource

    @Mock
    private lateinit var networkConfig: NetworkConfig

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(repository)
    }

    @Test
    fun getMovies() {
        val localMovies = Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_movies.json")),
            GetMoviesResponse::class.java
        )
        `when`(repository.getMovies()).thenReturn(MutableLiveData(localMovies))
        viewModel.getMovies()

        assertNotNull(localMovies)
        assertNotNull(viewModel.movies)
        assertEquals(localMovies, viewModel.movies.value)
        assertEquals(localMovies.results?.size, viewModel.movies.value?.results?.size)
    }
}