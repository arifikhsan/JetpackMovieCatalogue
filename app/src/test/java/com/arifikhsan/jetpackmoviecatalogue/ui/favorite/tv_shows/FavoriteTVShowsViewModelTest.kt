package com.arifikhsan.jetpackmoviecatalogue.ui.favorite.tv_shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
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
class FavoriteTVShowsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: FavoriteTVShowsViewModel

    @Mock
    private lateinit var repository: TVShowRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TVShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTVShowsViewModel(repository)
    }

    @Test
    fun getFavoriteTVShows() {
        val dummyTVShows = pagedList
        val randomNumber = (0 until 100).random()
        `when`(dummyTVShows.size).thenReturn(randomNumber)

        val movies = MutableLiveData<PagedList<TVShowEntity>>()
        movies.value = dummyTVShows

        `when`(repository.getFavoriteTVShows()).thenReturn(movies)
        val moviesEntity = viewModel.getFavoriteTVShows().value

        verify(repository).getFavoriteTVShows()
        assertNotNull(moviesEntity)
        assertEquals(randomNumber, moviesEntity?.size)

        viewModel.getFavoriteTVShows().observeForever(observer)
        verify(observer).onChanged(dummyTVShows)
    }
}
