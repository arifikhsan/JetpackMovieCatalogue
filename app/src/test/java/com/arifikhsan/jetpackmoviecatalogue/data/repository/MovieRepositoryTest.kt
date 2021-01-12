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

class MovieRepositoryTest {

//    private val remoteDataSource = mock(MovieRemoteDataSource::class.java)
//    private val repository = MovieRepository(remoteDataSource)

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
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        val movieEntity = MovieEntity.fromMovieResponse(dataDummy.getMovie())
        dummyMovie.value = movieEntity
        `when`(local.getMovie(sampleMovieId)).thenReturn(dummyMovie)

        val movie = LiveDataTestUtil.getValue(repository.getMovie(sampleMovieId))
        verify(local).getMovie(sampleMovieId)
        assertNotNull(movie)
        assertNotNull(movie.data)
        assertEquals(MovieEntity.fromMovieResponse(sampleMovieResponse), movie.data)
    }
//
//    @Test
//    fun getTVShows() {
//        val sampleTVShows = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_tv_shows.json")),
//            GetTVShowsResponse::class.java
//        )
//        `when`(remoteDataSource.getTVShows()).thenReturn(MutableLiveData(sampleTVShows))
//        val tvShows = repository.getTVShows()
//
//        verify(remoteDataSource).getTVShows()
//        assertEquals(sampleTVShows, tvShows.value)
//    }
//
//    @Test
//    fun getTVShowDetail() {
//        val sampleTVShow = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_tv_show.json")),
//            GetTVShowDetailResponse::class.java
//        )
//        var sampleTVShowId: Int
//        sampleTVShow?.id.let { sampleTVShowId = it ?: 0 }
//
//        `when`(remoteDataSource.getTVShowDetail(sampleTVShowId)).thenReturn(
//            MutableLiveData(
//                sampleTVShow
//            )
//        )
//        val tvShow = repository.getTVShowDetail(sampleTVShowId)
//
//        verify(remoteDataSource).getTVShowDetail(sampleTVShowId)
//        assertEquals(sampleTVShow, tvShow.value)
//    }
}