package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.MovieDao
import com.arifikhsan.jetpackmoviecatalogue.util.DataDummy
import com.arifikhsan.jetpackmoviecatalogue.util.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


//@RunWith(MockitoJUnitRunner::class)
//class MovieLocalDataSourceTest {
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private val dataDummy = DataDummy()
//    private val sampleMovieResponse = dataDummy.getMovie()
//    private val sampleMovieId = sampleMovieResponse.id!!
//
//    @Mock
//    private lateinit var local: MovieLocalDatasource
//    @Mock
//    private lateinit var dataSource: DataSource.Factory<Int, MovieEntity>
//
//    @Mock
//    private lateinit var dao: MovieDao
//
//    @Test
//    fun getMovies() {
//        `when`(dao.getMovies()).thenReturn(dataSource)
//
//        val localMovies = local.getMovies()

//        verify(dao).getMovies()
//        assertNotNull(localMovies)
//    }
//
//    @Test
//    fun getMovie() {
//        val dummyMovie = MutableLiveData<MovieEntity>()
//        val movieEntity = MovieEntity.fromMovieResponse(sampleMovieResponse)
//        dummyMovie.value = movieEntity
//        `when`(local.getMovie(sampleMovieId)).thenReturn(dummyMovie)
//
//        val localMovie = local.getMovie(sampleMovieId)
//        verify(local).getMovie(sampleMovieId)
//        assertNotNull(localMovie)
//    }
//
//    @Test
//    fun getFavoriteMovies() {
//        `when`(local.getFavoriteMovies()).thenReturn(dataSource)
//
//        val localMovies = local.getFavoriteMovies()
//        verify(local).getFavoriteMovies()
//        assertNotNull(localMovies)
//    }
//
//    @Test
//    fun getFavoriteCounts() {
//        val randomNumber = MutableLiveData<Int>()
//        randomNumber.value = (0 until 100).random()
//        `when`(local.getFavoriteCounts()).thenReturn(randomNumber)
//
//        val number = local.getFavoriteCounts()
//        verify(local).getFavoriteCounts()
//        assertEquals(randomNumber.value, number.value)
//    }
//}