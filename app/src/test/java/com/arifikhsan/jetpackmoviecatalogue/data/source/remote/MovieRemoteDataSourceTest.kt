package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.network.NetworkService
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.util.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieRemoteDataSourceTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataSource: MovieRemoteDataSource

    @Mock
    private lateinit var dummy: DataDummy

    @Mock
    private lateinit var apiService: NetworkService

    @Before
    fun setUp() {
        dataSource = MovieRemoteDataSource(apiService)
    }

    @Test
    fun getMovies() {
//        val moviesLive = MutableLiveData<ApiResponse<GetMoviesResponse>>()
//        moviesLive.value = ApiResponse.success(dummy.getMovies())
//        `when`(dataSource.getMovies()).thenReturn(moviesLive)

//        val actualMovies = dataSource.getMovies() // Parameter specified as non-null is null
//        verify(apiService).getMovies()
//        verify(dataSource).getMovies()
//        assertNotNull(actualMovies)
    }

    @Test
    fun getMovieDetail() {
    }
}