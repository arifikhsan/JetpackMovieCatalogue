package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

//@RunWith(MockitoJUnitRunner::class)
//class MovieRemoteDataSourceTest {
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    private lateinit var dataSource: MovieRemoteDataSource
//
//    @Mock
//    private lateinit var dummy: DataDummy
//
//    @Mock
//    private lateinit var apiService: NetworkService
//
//    @Before
//    fun setUp() {
//        dataSource = MovieRemoteDataSource(apiService)
//    }
//
//    @Test
//    fun getMovies() {
//        val moviesLive = MutableLiveData<ApiResponse<GetMoviesResponse>>()
//        moviesLive.value = ApiResponse.success(dummy.getMovies())
//        `when`(apiService.getMovies()).thenReturn(dummy.getMovies())

//        val actualMovies = dataSource.getMovies() // Parameter specified as non-null is null
//        verify(apiService).getMovies()
//        verify(dataSource).getMovies()
//        assertNotNull(actualMovies)
//    }
//
//    @Test
//    fun getMovieDetail() {
//    }
//}