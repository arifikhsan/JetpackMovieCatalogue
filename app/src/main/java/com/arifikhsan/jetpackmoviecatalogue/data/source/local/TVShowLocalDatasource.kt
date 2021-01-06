package com.arifikhsan.jetpackmoviecatalogue.data.source.local

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.TVShowDao

class TVShowLocalDatasource {
    private lateinit var mTVShowDao: TVShowDao
    lateinit var application: Application

//    companion object {
//        private var INSTANCE: TVShowLocalDatasource? = null
//
//        fun getInstance(tvShowDao: TVShowDao): TVShowLocalDatasource {
//            if (INSTANCE == null) {
//                INSTANCE = TVShowLocalDatasource(tvShowDao)
//            }
//
//            return INSTANCE as TVShowLocalDatasource
//        }
//    }

    init {
        val db = AppDatabase.getInstance(application)
        mTVShowDao = db.tvShowDao()
    }

    fun getTVShows(): DataSource.Factory<Int, TVShowEntity> {
        return mTVShowDao.getTVShows()
    }

    fun getFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity> {
        return mTVShowDao.getFavoriteTVShows()
    }

    fun getTVShow(id: Int): LiveData<TVShowEntity> {
        return mTVShowDao.getTVShow(id)
    }

    fun insertTVShow(movieEntity: TVShowEntity) {
        mTVShowDao.insertTVShow(movieEntity)
    }

    fun updateTVShow(tvShowEntity: TVShowEntity, newState: Boolean) {
        tvShowEntity.favorite = newState
        mTVShowDao.updateTVShow(tvShowEntity)
    }
}