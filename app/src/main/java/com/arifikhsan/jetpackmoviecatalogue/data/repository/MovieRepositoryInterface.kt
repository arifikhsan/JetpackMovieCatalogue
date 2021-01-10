package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

interface MovieRepositoryInterface {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getMovie(id: Int): LiveData<Resource<MovieEntity>>
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>
    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)
    fun getFavoriteMoviesCount(): LiveData<Int>
}
