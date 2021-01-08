package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

class MovieDetailViewModel(private val repository: MovieRepository) : ViewModel() {
    private var id = MutableLiveData<Int>()

    fun setMovieId(id: Int) {
        this.id.value = id
    }

    var movie: LiveData<Resource<MovieEntity>> =
        Transformations.switchMap(id) { mId ->
            repository.getMovie(mId)
        }

    fun setFavorite() {
        val movieResource = movie.value

        if (movieResource != null) {
            val movieData = movieResource.data

            movieData?.let {
                repository.setFavoriteMovie(it, !it.favorite)
            }
        }
    }
}