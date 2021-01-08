package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase

class TVShowLocalDatasource(database: AppDatabase) {
    private var tvShowDao = database.tvShowDao()

    fun getTVShows(): DataSource.Factory<Int, TVShowEntity> {
        return tvShowDao.getTVShows()
    }

    fun getFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity> {
        return tvShowDao.getFavoriteTVShows()
    }

    fun getTVShow(id: Int): LiveData<TVShowEntity> {
        return tvShowDao.getTVShow(id)
    }

    fun insertTVShows(tvShows: List<TVShowEntity>) {
        return tvShowDao.insertAll(tvShows)
    }

    fun insertTVShow(tvShowEntity: TVShowEntity) {
        tvShowDao.insertTVShow(tvShowEntity)
    }

    fun setTVShowFavorite(tvShowEntity: TVShowEntity, newState: Boolean) {
        tvShowEntity.favorite = newState
        tvShowDao.updateTVShow(tvShowEntity)
    }
}