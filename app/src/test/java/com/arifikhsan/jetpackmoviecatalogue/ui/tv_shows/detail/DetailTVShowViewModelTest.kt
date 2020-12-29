package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
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

//        assertEquals(sampleTVShow.popularity, tvShow?.popularity, 0.0001)
//        assertEquals(sampleTVShow.voteAverage, tvShow?.voteAverage, 0.0001)
    }
}