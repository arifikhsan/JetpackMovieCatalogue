package com.arifikhsan.jetpackmoviecatalogue.ui.favorite.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity

class FavoriteMoviesViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        return repository.getFavoriteMovies()
    }
}