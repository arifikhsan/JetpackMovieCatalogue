package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
//import androidx.test.platform.app.InstrumentationRegistry
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.injection.appModules
import com.arifikhsan.jetpackmoviecatalogue.util.JsonHelper
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

//@RunWith(MockitoJUnitRunner::class)
class MovieLocalDataSourceTest : KoinTest {

//    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
//    private val database = AppDatabase.getInstance(context)

//    private val local by inject<MovieLocalDatasource>()
    private val local = mock(MovieLocalDatasource::class.java)
    private val jsonHelper by inject<JsonHelper>()

    private lateinit var movies: ArrayList<MovieEntity>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
//        androidContext(context)
        modules(appModules)
    }

    @Before
    fun setUp() {
        val localMovies = jsonHelper.getMovies()
        movies = MovieEntity.fromMoviesResponse(localMovies) as ArrayList<MovieEntity>

        local.insertMovies(movies)
    }

//    @Test
//    fun getMovies() {
//        var dummyMovies: DataSource.Factory<Int, MovieEntity>
//        dummyMovies  = jsonHelper.getMovies()
//        `when`(local.getMovies()).thenReturn(dummyMovies)
//
//        assertNotNull(local.getMovies())
//    }
//
//    @Test
//    fun getMovie() {
//        val randomMovieId = movies.random().id
//        assertNotNull(local.getMovie(randomMovieId))
//    }
}