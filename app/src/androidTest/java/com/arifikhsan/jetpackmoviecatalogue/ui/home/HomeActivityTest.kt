package com.arifikhsan.jetpackmoviecatalogue.ui.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val networkConfig = NetworkConfig()
    private val dataSource = MovieRemoteDataSource(networkConfig)

    private val sampleMovies = dataSource.getMovies()
    private val sampleTVShows = dataSource.getTVShows()

    private lateinit var instrumentalContext: Context

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())

        ActivityScenario.launch(HomeActivity::class.java)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            sampleMovies.value?.results?.size?.let { scrollToPosition<RecyclerView.ViewHolder>(it) }
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("FILM")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

        val sampleMovie = sampleMovies.value?.results?.first()
        val position = sampleMovies.value?.results?.indexOf(sampleMovie)!!

        onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(position))
        onView(withId(R.id.rv_movies)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click())
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(sampleMovie?.title)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(sampleMovie?.overview)))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTVShows() {
        onView(withText("Serial TV")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))

        val size = sampleTVShows.value?.results?.size!!
        onView(withId(R.id.rv_tv_shows)).perform(scrollToPosition<RecyclerView.ViewHolder>(size))
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("Serial TV")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))

        val sampleTVShow = sampleTVShows.value?.results?.first()
        val position = sampleTVShows.value?.results?.indexOf(sampleTVShow)!!

        onView(withId(R.id.rv_tv_shows)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click())
        )

        onView(withId(R.id.tv_name)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_name)).check(matches(withText(sampleTVShow?.name)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(sampleTVShow?.overview)))
    }
}