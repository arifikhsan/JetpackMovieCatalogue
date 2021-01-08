package com.arifikhsan.jetpackmoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movies where favorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movies where id = :id")
    fun getMovie(id: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)
}