package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository

class MoviesViewModel : ViewModel() {
    fun getMovies(): ArrayList<MovieEntity> = MovieRepository.getMovies()
}