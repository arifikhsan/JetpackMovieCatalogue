package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository

class MoviesViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getMovies() = repository.getMovies()
}