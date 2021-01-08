package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Insert
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.MovieDao
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.MovieResultsItem

class MovieLocalDatasource(context: Context) {
    private var mMovieDao: MovieDao

    init {
        val db = AppDatabase.getInstance(context)
        mMovieDao = db.movieDao()
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

    fun insertMovies(movies: List<MovieEntity>) {
        return mMovieDao.insertAll(movies)
    }

    fun insertMovie(movieEntity: MovieEntity) {
        mMovieDao.insertMovie(movieEntity)
    }

    fun updateMovie(movieEntity: MovieEntity) {
        mMovieDao.updateMovie(movieEntity)
    }

    fun setMovieFavorite(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.favorite = newState
        mMovieDao.updateMovie(movieEntity)
    }
}