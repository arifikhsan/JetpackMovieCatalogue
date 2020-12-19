package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository

class DetailMovieViewModel: ViewModel() {
    private var movieId: Int = 0

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        val movies = MovieRepository.getMovies()
        return movies.find { it.id == movieId }!!
    }
}