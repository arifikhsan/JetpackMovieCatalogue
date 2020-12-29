package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.InputStreamReader

@RunWith(MockitoJUnitRunner::class)
class TVShowsViewModelTest {

    private lateinit var viewModel: TVShowsViewModel

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        viewModel = TVShowsViewModel(repository)
    }

    @Test
    fun getTVShows() {
        val sampleTVShows = Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_tv_shows.json")),
            GetTVShowsResponse::class.java
        )
        `when`(repository.getTVShows()).thenReturn(MutableLiveData(sampleTVShows))

        viewModel.getTVShows()

        assertNotNull(sampleTVShows)
        assertNotNull(viewModel.tvShows)
        assertEquals(sampleTVShows, viewModel.tvShows.value)
        assertEquals(sampleTVShows.results?.size, viewModel.tvShows.value?.results?.size)
    }
}