package com.arifikhsan.jetpackmoviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDataSource
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dataSource = MovieLocalDataSource()

    private val sampleMovies = dataSource.getMovies()
    private val sampleTVShows = dataSource.getTVShows()
    private val sampleMovie = dataSource.getMovieDetail()
    private val sampleTVShow = dataSource.getTVShowDetail()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            sampleMovies.results?.size?.let { scrollToPosition<RecyclerView.ViewHolder>(it) }
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("FILM")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

        Thread.sleep(2000)

        onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_movies)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        Thread.sleep(2000)

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_title)).check(matches(withText(sampleMovie.title)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(sampleMovie.overview)))
    }

    @Test
    fun loadTVShows() {
        onView(withText("Serial TV")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))

        val size = sampleTVShows.results?.size!!
        onView(withId(R.id.rv_tv_shows)).perform(scrollToPosition<RecyclerView.ViewHolder>(size))
    }

    @Test
    fun loadDetailTVShow() {
        Thread.sleep(2000)

        onView(withText("Serial TV")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        Thread.sleep(2000)

        onView(withId(R.id.tv_name)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_name)).check(matches(withText(sampleTVShow?.name)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(sampleTVShow?.overview)))
    }
}