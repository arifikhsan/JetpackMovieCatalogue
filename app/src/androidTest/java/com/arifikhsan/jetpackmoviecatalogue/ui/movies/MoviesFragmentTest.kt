package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.TVShowRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.ui.home.HomeActivity
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MoviesFragmentTest {
    private val networkConfig = NetworkConfig()
    private val movieRemoteDataSource = MovieRemoteDataSource(networkConfig.getApiService())
    private val tvShowRemoteDataSource = TVShowRemoteDataSource(networkConfig.getApiService())

    private lateinit var instrumentalContext: Context

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())

        ActivityScenario.launch(HomeActivity::class.java)

//        launchFragmentInContainer<MoviesFragment>()
//        val home = ActivityScenario.launch(HomeActivity::class.java).onActivity {
//            it.onAttachFragment()
//        }
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
//        val factory = MyFragmentFactory()
//        launchFragmentInContainer<MoviesFragment>()
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
//        val moviesSize = sampleMovies.value?.body?.results?.size!!
//        onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(moviesSize))
    }
}