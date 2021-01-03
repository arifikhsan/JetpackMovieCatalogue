# Jetpack Movie Catalogue

## Unit Test ViewModel Scenario

1. MoviesViewModelTest
  - Memastikan **movies** tidak null.
  - Memastikan jumlah **movies** sesuai (10).
  
2. DetailMoviesViewModelTest
  - Memastikan **movie** tidak null.
  - Memastikan **movie** sesuai.
  
3. TVShowViewModelTest
  - Memastikan **tv shows** tidak null.
  - Memastikan jumlah **tv shows** sesuai (10).
  
4. DetailTVShowViewModelTest
  - Memastikan **tv show** tidak null.
  - Memastikan **tv show** sesuai.

## Instrumental Test Scenario

1. Menampilkan Movies
  - Memastikan **rv_movies** dalam keadaan tampil.
  - Gulir **rv_movies** ke posisi data terakhir.
  
2. Menampilkan movie
  - Memberi tindakan klik pada data pertama di **rv_movies**.
  - Memastikan **TextView** untuk **title** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **overview** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **date** tampil sesuai dengan yang diharapkan.
  
3. Menampilkan tv shows
  - Memastikan **rv_tv_shows** dalam keadaan tampil.
  - Gulir **rv_tv_shows** ke posisi data terakhir.
  
4. Menampilkan tv show
  - Memberi tindakan klik pada data pertama di **rv_tv_shows**.
  - Memastikan **TextView** untuk **name** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **overview** tampil sesuai dengan yang diharapkan.
  - Memastikan **TextView** untuk **date** tampil sesuai dengan yang diharapkan.
  