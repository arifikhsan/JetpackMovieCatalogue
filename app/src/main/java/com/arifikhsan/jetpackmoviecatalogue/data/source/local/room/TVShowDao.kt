package com.arifikhsan.jetpackmoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity


@Dao
interface TVShowDao {
    @Query("SELECT * FROM tv_shows")
    fun getTVShows(): DataSource.Factory<Int, TVShowEntity>

    @Query("SELECT * FROM tv_shows where favorite = 1")
    fun getFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity>

    @Query("SELECT COUNT(id) FROM tv_shows WHERE favorite = 1")
    fun getFavoriteCounts(): LiveData<Int>

    @Query("SELECT * FROM tv_shows where id = :id")
    fun getTVShow(id: Int): LiveData<TVShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShow(movie: TVShowEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(movies: List<TVShowEntity>)

    @Update
    fun updateTVShow(movie: TVShowEntity)

    @Delete
    fun deleteTVShow(movie: TVShowEntity)
}