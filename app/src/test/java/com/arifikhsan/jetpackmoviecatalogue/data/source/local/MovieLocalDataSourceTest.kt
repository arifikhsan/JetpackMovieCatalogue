package com.arifikhsan.jetpackmoviecatalogue.data.source.local

//class MovieLocalDataSourceTest {
//
//    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
//    private val database = AppDatabase.getInstance(context)
//    private val local = MovieLocalDatasource(database)
//    private val jsonHelper = JsonHelper()
//
//    private lateinit var movies: ArrayList<MovieEntity>
//
//    @Before
//    fun setUp() {
//        movies = MovieEntity.fromMoviesResponse(jsonHelper.getMovies()) as ArrayList<MovieEntity>
//
//        local.insertMovies(movies)
//    }
//
//    @Test
//    fun getMovies() {
//        assertNotNull(local.getMovies())
//    }
//
//    @Test
//    fun getMovie() {
//        val randomMovieId = movies.random().id
//        assertNotNull(local.getMovie(randomMovieId))
//    }
//}