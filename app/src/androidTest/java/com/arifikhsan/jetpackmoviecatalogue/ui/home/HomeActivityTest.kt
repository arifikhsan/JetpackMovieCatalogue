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
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.TVShowRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val networkConfig = NetworkConfig()
    private val movieRemoteDataSource = MovieRemoteDataSource(networkConfig.getApiService())
    private val tvShowRemoteDataSource = TVShowRemoteDataSource(networkConfig.getApiService())

    private val sampleMovies = movieRemoteDataSource.getMovies()
    private val sampleTVShows = tvShowRemoteDataSource.getTVShows()

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
    fun loadMovieTab() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.fr_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTVShowTab() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.fr_tv_shows)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteTab() {
        onView(withText("FAVORITE")).perform(click())
        onView(withId(R.id.fr_favorite)).check(matches(isDisplayed()))
    }

    // Movies Fragment

    @Test
    fun loadMovies() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        val moviesSize = sampleMovies.value?.body?.results?.size!!
        onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(moviesSize))
    }


    @Test
    fun loadMovie() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

        val res = sampleMovies.value?.body?.results!!
        val sampleMovie = res.random()
        val position = res.indexOf(sampleMovie)

        onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(position))
        onView(withId(R.id.rv_movies)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click())
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_title)).check(matches(withText(sampleMovie?.title)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(sampleMovie?.overview)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_date)).check(matches(withText(sampleMovie?.releaseDate)))
    }

    @Test
    fun loadTVShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))

        val size = sampleTVShows.value?.body?.results?.size!!
        onView(withId(R.id.rv_tv_shows)).perform(scrollToPosition<RecyclerView.ViewHolder>(size))
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))

        val sampleTVShow = sampleTVShows.value?.body?.results?.first()
        val position = sampleTVShows.value?.body?.results?.indexOf(sampleTVShow)!!

        onView(withId(R.id.rv_tv_shows)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click())
        )

        onView(withId(R.id.tv_name)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_name)).check(matches(withText(sampleTVShow?.name)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(sampleTVShow?.overview)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_date)).check(matches(withText(sampleTVShow?.firstAirDate)))
    }
}