package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    lateinit var movie: LiveData<GetMovieDetailResponse?>
    private var id: Int = 0

    fun setMovieId(id: Int) {
        this.id = id
    }

    fun getMovieDetail() {
        movie = movieRepository.getMovieDetail(id)
    }
}