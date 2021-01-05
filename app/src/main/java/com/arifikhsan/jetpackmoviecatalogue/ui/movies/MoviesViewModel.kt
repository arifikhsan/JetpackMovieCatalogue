package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse

class MoviesViewModel(private val repository: MovieRepository) : ViewModel() {
    var movies = MutableLiveData<GetMoviesResponse?>()

    fun getMovies() {
        movies = repository.getMovies()
    }
}