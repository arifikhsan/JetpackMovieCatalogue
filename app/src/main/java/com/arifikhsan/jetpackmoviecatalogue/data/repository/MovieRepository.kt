package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.source.NetworkBoundResource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.ApiResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.util.AppExecutors
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

class MovieRepository(
    private val remote: MovieRemoteDataSource,
    private val local: MovieLocalDatasource,
    private val appExecutors: AppExecutors
) : MovieRepositoryInterface {

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, GetMoviesResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                val localMovies = local.getMovies()

                return LivePagedListBuilder(localMovies, config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<GetMoviesResponse>> {
                return remote.getMovies()
            }

            override fun saveCallResult(data: GetMoviesResponse) {
                val movies = GetMoviesResponse()
                local.insertMovies(movies)
            }
        }.asLiveData()
    }

    override fun getMovie(): LiveData<Resource<MovieEntity>> {
        TODO("Not yet implemented")
    }

//    fun getMovies(): MutableLiveData<GetMoviesResponse?> {
//        return remote.getMovies()
//    }
//
//    fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
//        return local.getMovieDetail(id)
//    }

//    fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
//        return remoteRemoteDataSource.getTVShows()
//    }
//
//    fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
//        return remoteRemoteDataSource.getTVShowDetail(id)
//    }
}