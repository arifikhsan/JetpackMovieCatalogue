package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse

class MoviesViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getMovies(): GetMoviesResponse? = repository.getMovies()
}