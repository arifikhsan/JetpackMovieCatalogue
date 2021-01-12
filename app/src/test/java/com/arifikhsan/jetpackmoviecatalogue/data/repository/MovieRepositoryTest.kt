package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.util.AppExecutors
import com.arifikhsan.jetpackmoviecatalogue.util.DataDummy
import com.arifikhsan.jetpackmoviecatalogue.util.LiveDataTestUtil
import com.arifikhsan.jetpackmoviecatalogue.util.PagedListUtil
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

@Suppress("UNCHECKED_CAST")
class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(MovieRemoteDataSource::class.java)
    private val local = mock(MovieLocalDatasource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)
    private val dataDummy = DataDummy()

    private val repository = MovieRepository(remote, local, appExecutor)

    private val sampleMoviesResponse = dataDummy.getMovies()
    private val sampleMovieResponse = dataDummy.getMovie()
    private val sampleMovieId = sampleMovieResponse.id!!

    @Test
    fun getMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        repository.getMovies()

        val moviesEntity = MovieEntity.fromMoviesResponse(dataDummy.getMovies())!!
        val moviesPaged = PagedListUtil.mockPagedList(moviesEntity)
        val moviesResource = Resource.success(moviesPaged)

        verify(local).getMovies()
        assertNotNull(moviesResource.data)
        assertEquals(sampleMoviesResponse.results?.size, moviesResource.data?.size)
    }

    @Test
    fun getMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        val movieEntity = MovieEntity.fromMovieResponse(sampleMovieResponse)
        dummyMovie.value = movieEntity
        `when`(local.getMovie(sampleMovieId)).thenReturn(dummyMovie)

        val movieLive = LiveDataTestUtil.getValue(repository.getMovie(sampleMovieId))
        verify(local).getMovie(sampleMovieId)
        assertNotNull(movieLive)
        assertNotNull(movieLive.data)
        assertEquals(movieEntity, movieLive.data)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        repository.getFavoriteMovies()

        val moviesEntity = MovieEntity.fromMoviesResponse(dataDummy.getMovies())!!
        val moviesPaged = PagedListUtil.mockPagedList(moviesEntity)
        val moviesResource = Resource.success(moviesPaged)

        verify(local).getFavoriteMovies()
        assertNotNull(moviesResource)
        assertEquals(sampleMoviesResponse.results?.size, moviesResource.data?.size)
    }

    @Test
    fun getFavoriteMoviesCount() {
        val randomNumber = MutableLiveData<Int>()
        randomNumber.value = (0 until 100).random()
        `when`(local.getFavoriteCounts()).thenReturn(randomNumber)

        val countLive = LiveDataTestUtil.getValue(repository.getFavoriteMoviesCount())
        verify(local).getFavoriteCounts()
        assertEquals(randomNumber.value, countLive)
    }
}