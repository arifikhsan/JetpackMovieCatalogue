package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.InputStreamReader

//@RunWith(MockitoJUnitRunner::class)
//class TVShowsViewModelTest {
//
//    private lateinit var viewModel: TVShowsViewModel
//
//    @Mock
//    private lateinit var repository: MovieRepository
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    private lateinit var observer: Observer<GetTVShowsResponse?>
//
//    @Before
//    fun setUp() {
//        viewModel = TVShowsViewModel(repository)
//    }
//
//    @Test
//    fun getTVShows() {
//        val sampleTVShows = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_tv_shows.json")),
//            GetTVShowsResponse::class.java
//        )
//        val tvShows = MutableLiveData<GetTVShowsResponse>()
//        tvShows.value = sampleTVShows
//
//        `when`(repository.getTVShows()).thenReturn(MutableLiveData(sampleTVShows))
//        viewModel.getTVShows()
//
//        assertNotNull(sampleTVShows)
//        assertNotNull(viewModel.tvShows)
//        assertEquals(sampleTVShows, viewModel.tvShows.value)
//        assertEquals(sampleTVShows.results?.size, viewModel.tvShows.value?.results?.size)
//
//        viewModel.tvShows.observeForever(observer)
//        verify(observer).onChanged(sampleTVShows)
//    }
//}