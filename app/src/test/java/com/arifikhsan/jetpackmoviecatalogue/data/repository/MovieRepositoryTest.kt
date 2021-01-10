package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*
import java.io.InputStreamReader

//class MovieRepositoryTest {
//
//    private val remoteDataSource = mock(MovieRemoteDataSource::class.java)
//    private val repository = MovieRepository(remoteDataSource)
//
//    @Test
//    fun getMovies() {
//        val sampleMovies = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_movies.json")),
//            GetMoviesResponse::class.java
//        )
//        `when`(remoteDataSource.getMovies()).thenReturn(MutableLiveData(sampleMovies))
//        val movies = repository.getMovies()
//
//        verify(remoteDataSource).getMovies()
//        assertEquals(sampleMovies, movies.value)
//    }
//
//    @Test
//    fun getMovieDetail() {
//        val sampleMovie = Gson().fromJson(
//            InputStreamReader(javaClass.getResourceAsStream("get_movie.json")),
//            GetMovieDetailResponse::class.java
//        )
//        var sampleMovieId: Int
//        sampleMovie?.id.let { sampleMovieId = it ?: 0 }
//
//        `when`(remoteDataSource.getMovieDetail(sampleMovieId)).thenReturn(
//            MutableLiveData(
//                sampleMovie
//            )
//        )
//        val movie = repository.getMovieDetail(sampleMovieId)
//
//        verify(remoteDataSource).getMovieDetail(sampleMovieId)
//        assertEquals(sampleMovie, movie.value)
//    }
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
//}