package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteDataSource(private val networkConfig: NetworkConfig) {

    companion object {
        private val TAG = MovieRemoteDataSource::class.java.simpleName
    }

    fun getMovies(): MutableLiveData<GetMoviesResponse?> {
        val movies = MutableLiveData<GetMoviesResponse?>()
        val client = networkConfig.getApiService().getMovies()

        client
            .enqueue(object :
                Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { movies.postValue(it) }
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                }
            })

        return movies
    }

    fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
        val movie = MutableLiveData<GetMovieDetailResponse?>()
        val client = networkConfig.getApiService().getMovieDetail(id)

        client
            .enqueue(object :
                Callback<GetMovieDetailResponse> {
                override fun onResponse(
                    call: Call<GetMovieDetailResponse>,
                    response: Response<GetMovieDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { movie.postValue(it) }
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GetMovieDetailResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                }
            })

        return movie
    }

    fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
        val tvShows = MutableLiveData<GetTVShowsResponse?>()

        val client = networkConfig.getApiService().getTVShows()

        client
            .enqueue(object :
                Callback<GetTVShowsResponse> {
                override fun onResponse(
                    call: Call<GetTVShowsResponse>,
                    response: Response<GetTVShowsResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { tvShows.postValue(it) }
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GetTVShowsResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                }
            })

        return tvShows
    }

    fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
        val tvShow = MutableLiveData<GetTVShowDetailResponse?>()
        val client = networkConfig.getApiService().getTVShowDetail(id)

        client
            .enqueue(object :
                Callback<GetTVShowDetailResponse> {
                override fun onResponse(
                    call: Call<GetTVShowDetailResponse>,
                    response: Response<GetTVShowDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { tvShow.postValue(it) }
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<GetTVShowDetailResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message.toString()}")
                }
            })

        return tvShow
    }
}