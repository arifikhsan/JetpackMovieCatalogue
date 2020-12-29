package com.arifikhsan.jetpackmoviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDataSource
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dataSource = MovieLocalDataSource()

    private val sampleMovies = dataSource.getMovies()
    private val sampleTVShows = dataSource.getTVShows()
    private val sampleMovie = sampleMovies.value?.results?.random()
    private val sampleTVShow = sampleTVShows.value?.results?.random()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

//    @After
//    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
//    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            sampleMovies.value?.results?.size?.let {
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(it)
            }
        )
    }

    @Test
    fun loadDetailMovie() {
        val movieId = sampleMovies.value?.results?.indexOf(sampleMovie) ?: 0
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(movieId, click())
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_title)).check(matches(withText(sampleMovie?.title)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(sampleMovie?.overview)))
    }

    @Test
    fun loadTVShows() {
        onView(withText("Serial TV")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                sampleTVShows.value?.results?.size!!
            )
        )
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("Serial TV")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(
            sampleTVShows.value?.results?.indexOf(sampleTVShow)?.let {
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(it, click())
            }
        )

        onView(withId(R.id.tv_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_name)).check(matches(withText(sampleTVShow?.name)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(sampleTVShow?.overview)))
    }
}