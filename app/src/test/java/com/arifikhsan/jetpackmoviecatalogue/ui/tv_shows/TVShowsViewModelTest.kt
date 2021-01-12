package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TVShowsViewModel

    @Mock
    private lateinit var repository: TVShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TVShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = TVShowsViewModel(repository)
    }

    @Test
    fun getTVShows() {
        val dummyTVShows = Resource.success(pagedList)
        val randomNumber = (0 until 100).random()
        `when`(dummyTVShows.data?.size).thenReturn(randomNumber)
        val tvShows = MutableLiveData<Resource<PagedList<TVShowEntity>>>()
        tvShows.value = dummyTVShows

        `when`(repository.getTVShows()).thenReturn(tvShows)
        val tvShowsEntity = viewModel.getTVShows().value?.data

        verify(repository).getTVShows()
        assertNotNull(tvShowsEntity)
        assertEquals(randomNumber, tvShowsEntity?.size)

        viewModel.getTVShows().observeForever(observer)
        verify(observer).onChanged(dummyTVShows)
    }
}