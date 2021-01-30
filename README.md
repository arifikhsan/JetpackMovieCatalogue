# Jetpack Movie Catalogue

## Unit Test

### Unit Test ViewModel Movies

1. MoviesViewModelTest
  - Memastikan **getMovies()** tidak null.
  - Memastikan jumlah **getMovies()** nilainya sesuai.
  
2. DetailMoviesViewModelTest
  - Memastikan **movie** tidak null.
  - Memastikan **movie** nilainya sesuai.
  
### Unit Test ViewModel TV Shows

1. TVShowViewModelTest
  - Memastikan **getTVShows()** tidak null.
  - Memastikan jumlah **getTVShows()** nilainya sesuai.
  
2. DetailTVShowViewModelTest
  - Memastikan **tv show** tidak null.
  - Memastikan **tv show** nilainya sesuai.

### Unit Test ViewModel Favorites

1. FavoriteViewModelTest
  - Memastikan **getFavoriteMoviesCount()** tidak null.
  - Memastikan **getFavoriteMoviesCount()** nilainya sesuai.
  
2. FavoriteMoviesViewModelTest
  - Memastikan **getFavoriteMovies()** tidak null.
  - Memastikan **getFavoriteMovies()** nilainya sesuai.
  
3. FavoriteTVShowsViewModelTest
  - Memastikan **getFavoriteTVShows()** tidak null.
  - Memastikan **getFavoriteTVShows()** nilainya sesuai.
  
## Instrumentation Test Scenario

### Home Activity

1. Menampilkan Fragment Movies
  - Klik tab **MOVIES**.
  - Memastikan **fr_movies** dalam keadaan tampil.

2. Menampilkan Fragment TV Show
  - Klik tab **TV SHOWS**.
  - Memastikan **fr_tv_shows** dalam keadaan tampil.
  
3. Menampilkan Fragment Favorite
  - Klik tab **FAVORITES**.
  - Memastikan **fr_favorite** dalam keadaan tampil. 

## Movies Fragment

1. Menampilkan Movies
  - Klik tab **MOVIES**.
  - Memastikan **rv_movies** dalam keadaan tampil.
  - Gulir **rv_movies** ke posisi data terakhir.
  
2. Menampilkan Movie
  - Klik tab **MOVIES**.
  - Memastikan **rv_movies** dalam keadaan tampil.
  - Memberi tindakan klik pada data pertama di **rv_movies**.
  - Memastikan **TextView** untuk **title** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **overview** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **date** tampil sesuai dengan yang diharapkan.
  
3. Menampilkan Favorite Movie
  - Klik tab **MOVIES**.
  - Memastikan **rv_movies** dalam keadaan tampil.
  - Memberi tindakan klik pada film pertama di **rv_movies**.
  - Klik tombol favorite di **action_favorite**.
  - Klik tombol kembali (up button).
  - Klik tab **FAVORITE**.
  - Memastikan **TextView** untuk **tv_movies_count** bertuliskan "1 items"
  - Klik card **card_movies**.
  - Memastikan ada film yang dengan **title** sama.
  - Klik film tersebut.
  - Memastikan **TextView** untuk **title** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **overview** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **date** tampil sesuai dengan yang diharapkan.
  - Klik tombol favorite di **action_favorite**.
  - Klik tombol kembali (up button).
  - Memastikan recyclerview **rv_movies** kosong.
  - Klik tombol kembali (up button).
  - Memastikan **TextView** untuk **tv_movies_count** bertuliskan "0 items"
  
## Movies TV Shows

1. Menampilkan tv shows
  - Klik tab **TV SHOWS**.
  - Memastikan **rv_tv_shows** dalam keadaan tampil.
  - Gulir **rv_tv_shows** ke posisi data terakhir.
  
2. Menampilkan tv show
  - Klik tab **TV SHOWS**.
  - Memastikan **rv_tv_shows** dalam keadaan tampil.
  - Memberi tindakan klik pada data pertama di **rv_tv_shows**.
  - Memastikan **TextView** untuk **name** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **overview** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **date** tampil sesuai dengan yang diharapkan.
  
3. Menampilkan Favorite TV Shows
  - Klik tab **TV SHOWS**.
  - Memastikan **rv_tv_shows** dalam keadaan tampil.
  - Memberi tindakan klik pada serial TV pertama di **rv_tv_shows**.
  - Klik tombol favorite di **action_favorite**.
  - Klik tombol kembali (up button).
  - Klik tab **FAVORITE**.
  - Memastikan **TextView** untuk **tv_tv_show_count** bertuliskan "1 items"
  - Klik card **card_tv_shows**.
  - Memastikan ada serial TV yang dengan **name** sama.
  - Klik serial TV tersebut.
  - Memastikan **TextView** untuk **name** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **overview** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **date** tampil sesuai dengan yang diharapkan.
  - Klik tombol favorite di **action_favorite**.
  - Klik tombol kembali (up button).
  - Memastikan recyclerview **rv_tv_shows** kosong.
  - Klik tombol kembali (up button).
  - Memastikan **TextView** untuk **tv_tv_show_count** bertuliskan "0 items"
  