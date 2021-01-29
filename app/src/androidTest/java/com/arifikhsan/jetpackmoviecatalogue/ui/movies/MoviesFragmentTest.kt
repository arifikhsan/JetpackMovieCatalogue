package com.arifikhsan.jetpackmoviecatalogue.ui.movies

//class MoviesFragmentTest {
//    private val networkConfig = NetworkConfig()
//    private val movieRemoteDataSource = MovieRemoteDataSource(networkConfig.getApiService())
//    private val tvShowRemoteDataSource = TVShowRemoteDataSource(networkConfig.getApiService())
//
//    private lateinit var instrumentalContext: Context
//
//    @Before
//    fun setUp() {
//        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
//
//        ActivityScenario.launch(HomeActivity::class.java)

//        launchFragmentInContainer<MoviesFragment>()
//        val home = ActivityScenario.launch(HomeActivity::class.java).onActivity {
//            it.onAttachFragment()
//        }
//    }
//
//    @After
//    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
//    }
//
//    @Test
//    fun loadMovies() {
//        val factory = MyFragmentFactory()
//        launchFragmentInContainer<MoviesFragment>()
//        onView(withText("MOVIES")).perform(click())
//        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
//        val moviesSize = sampleMovies.value?.body?.results?.size!!
//        onView(withId(R.id.rv_movies)).perform(scrollToPosition<RecyclerView.ViewHolder>(moviesSize))
//    }
//}