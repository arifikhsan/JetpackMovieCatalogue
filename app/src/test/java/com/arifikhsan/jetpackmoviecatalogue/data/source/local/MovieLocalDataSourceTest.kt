package com.arifikhsan.jetpackmoviecatalogue.data.source.local

//import androidx.test.platform.app.InstrumentationRegistry

//class MovieLocalDataSourceTest : KoinTest {

//    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
//    val context = ApplicationPro
//    private val database = AppDatabase.getInstance(context)

//    private val local by inject<MovieLocalDatasource>()
//    private val local = mock(MovieLocalDatasource::class.java)
//    private val jsonHelper by inject<JsonHelper>()
//
//    private lateinit var movies: ArrayList<MovieEntity>
//
//    @get:Rule
//    val koinTestRule = KoinTestRule.create {
//        androidContext(context)
//        modules(appModules)
//    }
//
//    @Before
//    fun setUp() {
//        val localMovies = jsonHelper.getMovies()
//        movies = MovieEntity.fromMoviesResponse(localMovies) as ArrayList<MovieEntity>
//
//        local.insertMovies(movies)
//    }
//
//    @Test
//    fun getMovies() {
//        var dummyMovies: DataSource.Factory<Int, MovieEntity>
//        dummyMovies  = jsonHelper.getMovies()
//        `when`(local.getMovies()).thenReturn(dummyMovies)

//        assertNotNull(local.getMovies())
//    }
//
//    @Test
//    fun getMovie() {
//        val randomMovieId = movies.random().id
//        assertNotNull(local.getMovie(randomMovieId))
//    }
//}