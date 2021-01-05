package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.MovieDao

class MovieLocalDatasource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: MovieLocalDatasource? = null

        fun getInstance(movieDao: MovieDao): MovieLocalDatasource {
            if (INSTANCE == null) {
                INSTANCE = MovieLocalDatasource(movieDao)
            }

            return INSTANCE as MovieLocalDatasource
        }
    }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> {
        return mMovieDao.getMovies()
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> {
        return mMovieDao.getFavoriteMovies()
    }

    fun getMovie(id: Int): LiveData<MovieEntity> {
        return mMovieDao.getMovie(id)
    }

    fun insertMovie(movieEntity: MovieEntity) {
        mMovieDao.insertMovie(movieEntity)
    }

    fun updateMovie(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.favorite = newState
        mMovieDao.updateMovie(movieEntity)
    }
}