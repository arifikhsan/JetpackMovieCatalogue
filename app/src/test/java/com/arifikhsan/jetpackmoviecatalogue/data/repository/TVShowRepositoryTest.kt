package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.TVShowLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.TVShowRemoteDataSource
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
class TVShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(TVShowRemoteDataSource::class.java)
    private val local = mock(TVShowLocalDatasource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)
    private val dataDummy = DataDummy()

    private val repository = TVShowRepository(remote, local, appExecutor)

    private val sampleTVShowsResponse = dataDummy.getTVShows()
    private val sampleTVShowResponse = dataDummy.getTVShow()
    private val sampleTVShowId = sampleTVShowResponse.id!!


    @Test
    fun getTVShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getTVShows()).thenReturn(dataSourceFactory)
        repository.getTVShows()

        val tvShowsEntity = TVShowEntity.fromTVShowsResponse(dataDummy.getTVShows())!!
        val tvShowsPaged = PagedListUtil.mockPagedList(tvShowsEntity)
        val tvShowsResource = Resource.success(tvShowsPaged)

        verify(local).getTVShows()
        assertNotNull(tvShowsResource.data)
        assertEquals(sampleTVShowsResponse.results?.size, tvShowsResource.data?.size)
    }

    @Test
    fun getTVShow() {
        val dummyTVShow = MutableLiveData<TVShowEntity>()
        val tvShowEntity = TVShowEntity.fromTVShowResponse(sampleTVShowResponse)
        dummyTVShow.value = tvShowEntity
        `when`(local.getTVShow(sampleTVShowId)).thenReturn(dummyTVShow)

        val tvShowLive = LiveDataTestUtil.getValue(repository.getTVShow(sampleTVShowId))
        verify(local).getTVShow(sampleTVShowId)
        assertNotNull(tvShowLive)
        assertNotNull(tvShowLive.data)
        assertEquals(tvShowEntity, tvShowLive.data)
    }

    @Test
    fun getFavoriteTVShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getFavoriteTVShows()).thenReturn(dataSourceFactory)
        repository.getFavoriteTVShows()

        val tvShowsEntity = MovieEntity.fromMoviesResponse(dataDummy.getMovies())!!
        val tvShowsPaged = PagedListUtil.mockPagedList(tvShowsEntity)
        val tvShowsResource = Resource.success(tvShowsPaged)

        verify(local).getFavoriteTVShows()
        assertNotNull(tvShowsResource)
        assertEquals(sampleTVShowsResponse.results?.size, tvShowsResource.data?.size)
    }

    @Test
    fun setFavoriteTVShow() {
    }

    @Test
    fun getFavoriteTVShowsCount() {
        val randomNumber = MutableLiveData<Int>()
        randomNumber.value = (0 until 100).random()
        `when`(local.getFavoriteCounts()).thenReturn(randomNumber)

        val countLive = LiveDataTestUtil.getValue(repository.getFavoriteTVShowsCount())
        verify(local).getFavoriteCounts()
        assertEquals(randomNumber.value, countLive)
    }
}