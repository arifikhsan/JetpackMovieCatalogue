package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.MovieDao
import com.arifikhsan.jetpackmoviecatalogue.util.DataDummy
import com.arifikhsan.jetpackmoviecatalogue.util.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


@Suppress("UNCHECKED_CAST")
class MovieLocalDataSourceTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val local = mock(MovieLocalDatasource::class.java)
    private val movieDao = mock(MovieDao::class.java)

    private val dataDummy = DataDummy()
    private val sampleMoviesEntity = MovieEntity.fromMoviesResponse(dataDummy.getMovies())

    private val sampleMoviesResponse = dataDummy.getMovies()
    private val sampleMovieResponse = dataDummy.getMovie()
    private val sampleMovieId = sampleMovieResponse.id!!

    @Test
    fun getMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)

        val localMovies = local.getMovies()
        verify(local).getMovies()
//        verify(movieDao).getMovies()
        assertNotNull(localMovies)
    }

    @Test
    fun getMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        val movieEntity = MovieEntity.fromMovieResponse(sampleMovieResponse)
        dummyMovie.value = movieEntity
        `when`(local.getMovie(sampleMovieId)).thenReturn(dummyMovie)

        val localMovie = local.getMovie(sampleMovieId)
        verify(local).getMovie(sampleMovieId)
        assertNotNull(localMovie)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)

        val localMovies = local.getFavoriteMovies()
        verify(local).getFavoriteMovies()
        assertNotNull(localMovies)
    }

    @Test
    fun getFavoriteCounts() {
        val randomNumber = MutableLiveData<Int>()
        randomNumber.value = (0 until 100).random()
        `when`(local.getFavoriteCounts()).thenReturn(randomNumber)

        val number = local.getFavoriteCounts()
        verify(local).getFavoriteCounts()
        assertEquals(randomNumber.value, number.value)
    }
}