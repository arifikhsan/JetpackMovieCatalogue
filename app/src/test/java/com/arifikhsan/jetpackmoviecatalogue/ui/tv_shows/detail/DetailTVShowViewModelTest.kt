package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.InputStreamReader

@RunWith(MockitoJUnitRunner::class)
class DetailTVShowViewModelTest {

    private lateinit var viewModel: DetailTVShowViewModel
    private lateinit var sampleTVShow: GetTVShowDetailResponse
    private var sampleTVShowId: Int = 0

    @Mock
    private lateinit var repository: MovieRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<GetTVShowDetailResponse?>

    @Before
    fun setUp() {
        viewModel = DetailTVShowViewModel(repository)
    }

    @Test
    fun getTVShow() {
        sampleTVShow = Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_tv_show.json")),
            GetTVShowDetailResponse::class.java
        )
        val tvShowLive = MutableLiveData<GetTVShowDetailResponse>()
        tvShowLive.value = sampleTVShow

        sampleTVShow.id?.let { sampleTVShowId = it }
        `when`(repository.getTVShowDetail(sampleTVShowId)).thenReturn(MutableLiveData(sampleTVShow))

        viewModel.setTVShowId(sampleTVShowId)
        viewModel.getTVShowDetail()
        val tvShow = viewModel.tvShow.value

        assertNotNull(tvShow)

        assertEquals(sampleTVShow.id, tvShow?.id)
        assertEquals(sampleTVShow.name, tvShow?.name)
        assertEquals(sampleTVShow.overview, tvShow?.overview)
        assertEquals(sampleTVShow.posterPath, tvShow?.posterPath)
        assertEquals(sampleTVShow.firstAirDate, tvShow?.firstAirDate)
        assertEquals(sampleTVShow.voteCount, tvShow?.voteCount)

        assertEquals(sampleTVShow.popularity as Double, tvShow?.popularity as Double, 0.0001)
        assertEquals(sampleTVShow.voteAverage as Double, tvShow.voteAverage as Double, 0.0001)

        viewModel.tvShow.observeForever(observer)
        verify(observer).onChanged(sampleTVShow)
    }
}