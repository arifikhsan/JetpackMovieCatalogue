package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
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

//@RunWith(MockitoJUnitRunner::class)
//class MovieDetailViewModelTest {
//
//    private lateinit var detailViewModel: MovieDetailViewModel
//    private lateinit var sampleMovie: GetMovieDetailResponse
//    private var sampleMovieId: Int = 0
//
//    @Mock
//    private lateinit var repository: MovieRepository
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    private lateinit var observer: Observer<GetMovieDetailResponse?>
//
//    @Before
//    fun setUp() {
//        detailViewModel = MovieDetailViewModel(repository)
//    }
//
//    @Test
//    fun getMovie() {
//        sampleMovie = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_movie.json")),
//            GetMovieDetailResponse::class.java
//        )
//        val movieLive = MutableLiveData<GetMovieDetailResponse>()
//        movieLive.value = sampleMovie
//
//
//        sampleMovie.id?.let { sampleMovieId = it }
//        `when`(repository.getMovieDetail(sampleMovieId)).thenReturn(MutableLiveData(sampleMovie))
//
//        detailViewModel.setMovieId(sampleMovieId)
//        detailViewModel.getMovieDetail()
//        val movie = detailViewModel.movie.value
//
//        assertNotNull(movie)
//        assertEquals(sampleMovie.id, movie?.id)
//        assertEquals(sampleMovie.title, movie?.title)
//        assertEquals(sampleMovie.overview, movie?.overview)
//        assertEquals(sampleMovie.posterPath, movie?.posterPath)
//        assertEquals(sampleMovie.releaseDate, movie?.releaseDate)
//        assertEquals(sampleMovie.voteCount, movie?.voteCount)
//
//        assertEquals(sampleMovie.popularity as Double, movie?.popularity as Double, 0.0001)
//        assertEquals(sampleMovie.voteAverage as Double, movie.voteAverage as Double, 0.0001)
//
//        detailViewModel.movie.observeForever(observer)
//        verify(observer).onChanged(sampleMovie)
//    }
//}