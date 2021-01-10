package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.source.NetworkBoundResource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.TVShowLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.ApiResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.TVShowRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.util.AppExecutors
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

class TVShowRepository(
    private val remote: TVShowRemoteDataSource,
    private val local: TVShowLocalDatasource,
    private val appExecutors: AppExecutors
) : TVShowRepositoryInterface {

    override fun getTVShows(): LiveData<Resource<PagedList<TVShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TVShowEntity>, GetTVShowsResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TVShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                val localTVShows = local.getTVShows()
                return LivePagedListBuilder(localTVShows, config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<GetTVShowsResponse>> {
                return remote.getTVShows()
            }

            override fun saveCallResult(data: GetTVShowsResponse) {
                TVShowEntity.fromTVShowsResponse(data)?.let { local.insertTVShows(it) }
            }
        }.asLiveData()
    }

    override fun getTVShow(id: Int): LiveData<Resource<TVShowEntity>> {
        return object : NetworkBoundResource<TVShowEntity, GetTVShowDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TVShowEntity> {
                return local.getTVShow(id)
            }

            override fun shouldFetch(data: TVShowEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<GetTVShowDetailResponse>> {
                return remote.getTVShowDetail(id)
            }

            override fun saveCallResult(data: GetTVShowDetailResponse) {
                val tvShow = TVShowEntity.fromTVShowResponse(data)
                local.insertTVShow(tvShow)
            }

        }.asLiveData()
    }

    override fun getFavoriteTVShows(): LiveData<PagedList<TVShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(local.getFavoriteTVShows(), config).build()
    }

    override fun setFavoriteTVShow(tvShow: TVShowEntity, state: Boolean) {
        return appExecutors.diskIO().execute { local.setTVShowFavorite(tvShow, state) }
    }

    fun getFavoriteTVShowsCount(): LiveData<Int> {
        return local.getFavoriteCounts()
    }
}