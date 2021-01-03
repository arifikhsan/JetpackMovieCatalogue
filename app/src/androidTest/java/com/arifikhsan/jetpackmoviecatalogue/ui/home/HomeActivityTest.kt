package com.arifikhsan.jetpackmoviecatalogue.ui.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.registerIdlingResources
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDataSource
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dataSource = MovieLocalDataSource()
    private lateinit var instrumentalContext: Context

//    private val sampleMovies = dataSource.getMovies()
//    private val sampleTVShows = dataSource.getTVShows()
//    private val sampleMovie = dataSource.getMovieDetail()
//    private val sampleTVShow = sampleTVShows?.results?.random()

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext

        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        val sampleMovies = dataSource.getMovies()

        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            sampleMovies.results?.size?.let { scrollToPosition<RecyclerView.ViewHolder>(it) }
        )
    }

    @Test
    fun loadDetailMovie() {
        val sampleMovies = dataSource.getMovies()
        println(sampleMovies)

        onView(withText("FILM")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

//        val sampleMovie = sampleMovies.results?.random()
//        val movieId = sampleMovies.results?.indexOf(sampleMovie)

//        movieId?.let {
            onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(0))
            onView(withId(R.id.rv_movies)).perform(
                actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
            )
//        }
//            onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
//            onView(withId(R.id.tv_title)).check(matches(withText(sampleMovie?.title)))
//            onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//            onView(withId(R.id.tv_overview)).check(matches(withText(sampleMovie?.overview)))

    }

//    @Test
//    fun loadTVShows() {
//        onView(withText("Serial TV")).perform(click())
//        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
//
//        val size = sampleTVShows.value?.results?.size!!
//        onView(withId(R.id.rv_tv_shows)).perform(scrollToPosition<RecyclerView.ViewHolder>(size))
//    }

//    @Test
//    fun loadDetailTVShow() {
//        onView(withText("Serial TV")).perform(click())
//        onView(withId(R.id.rv_tv_shows)).perform(
//            sampleTVShows.value?.results?.indexOf(sampleTVShow)?.let {
//                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(it, click())
//            }
//        )
//
//        onView(withId(R.id.tv_name)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_name)).check(matches(withText(sampleTVShow?.name)))
//        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(sampleTVShow?.overview)))
//    }
}