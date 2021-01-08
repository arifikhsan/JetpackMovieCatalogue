package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase

class MovieLocalDatasource(database: AppDatabase) {
    private var movieDao = database.movieDao()

    fun getMovies(): DataSource.Factory<Int, MovieEntity> {
        return movieDao.getMovies()
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> {
        return movieDao.getFavoriteMovies()
    }

    fun getMovie(id: Int): LiveData<MovieEntity> {
        return movieDao.getMovie(id)
    }

    fun insertMovies(movies: List<MovieEntity>) {
        return movieDao.insertAll(movies)
    }

    fun insertMovie(movieEntity: MovieEntity) {
        movieDao.insertMovie(movieEntity)
    }

    fun updateMovie(movieEntity: MovieEntity) {
        movieDao.updateMovie(movieEntity)
    }

    fun setMovieFavorite(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.favorite = newState
        movieDao.updateMovie(movieEntity)
    }
}