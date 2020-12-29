package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
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
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var sampleMovie: GetMovieDetailResponse
    private var sampleMovieId: Int = 0

    @Mock
    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
    }

    @Test
    fun getMovie() {
        sampleMovie = Gson().fromJson(
            InputStreamReader(javaClass.getResourceAsStream("get_movie.json")),
            GetMovieDetailResponse::class.java
        )
        sampleMovie.id?.let { sampleMovieId = it }
        `when`(repository.getMovieDetail(sampleMovieId)).thenReturn(MutableLiveData(sampleMovie))

        viewModel.setMovieId(sampleMovieId)
        viewModel.getMovieDetail()
        val movie = viewModel.movie.value

        assertNotNull(movie)
        assertEquals(sampleMovie.id, movie?.id)
        assertEquals(sampleMovie.title, movie?.title)
        assertEquals(sampleMovie.overview, movie?.overview)
        assertEquals(sampleMovie.posterPath, movie?.posterPath)
        assertEquals(sampleMovie.releaseDate, movie?.releaseDate)
        assertEquals(sampleMovie.voteCount, movie?.voteCount)

        assertEquals(sampleMovie.popularity as Double, movie?.popularity as Double, 0.0001)
        assertEquals(sampleMovie.voteAverage as Double, movie.voteAverage as Double, 0.0001)
    }
}