package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.MovieDao
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.MovieResultsItem

class MovieLocalDatasource {
    private lateinit var mMovieDao: MovieDao
    lateinit var application: Application

//    companion object {
//        private var INSTANCE: MovieLocalDatasource? = null
//
//        fun getInstance(movieDao: MovieDao): MovieLocalDatasource {
//            if (INSTANCE == null) {
//                INSTANCE = MovieLocalDatasource(movieDao)
//            }
//
//            return INSTANCE as MovieLocalDatasource
//        }
//    }

    init {
        val db = AppDatabase.getInstance(application)
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

    fun insertMovies(movies: GetMoviesResponse) {
        movies.results?.let {
            it.forEach { movie -> insertMovie(MovieResultsItem.toEntity(movie)) }
        }
    }

    fun insertMovie(movieEntity: MovieEntity) {
        mMovieDao.insertMovie(movieEntity)
    }

    fun updateMovie(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.favorite = newState
        mMovieDao.updateMovie(movieEntity)
    }
}