package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import android.util.JsonReader
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import com.google.gson.Gson
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.koin.java.KoinJavaComponent.inject
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.notNull
import java.io.File
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
        val reader = InputStreamReader(javaClass.getResourceAsStream("get_movies.json"))
        val result = Gson().fromJson(reader, GetMoviesResponse::class.java)
        println(result)
//        println(apa)
//        `when`(repository.getMovies()).thenReturn()
//        val movies = viewModel.getMovies()
//
//        assertNotNull(movies)
//        assertEquals(10, movies.size)
    }

    @Test
    fun notGetMovies() {
//        val movies = arrayListOf<MovieModel>()
//
//        assertFalse(movies.isNotEmpty())
//        assertNotEquals(10, movies.size)
    }

    @Test
    fun setMovies() {
    }

    @Test
    fun testGetMovies() {
    }
}