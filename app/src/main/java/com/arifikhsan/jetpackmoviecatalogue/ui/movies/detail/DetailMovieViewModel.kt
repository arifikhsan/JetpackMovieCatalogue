package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    lateinit var movie: LiveData<Resource<MovieEntity>>
    private var id: Int = 0

    fun setMovieId(id: Int) {
        this.id = id
    }

    fun getMovieDetail() {
        movie = movieRepository.getMovie(id)
    }
}