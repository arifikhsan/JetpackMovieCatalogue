package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.MovieDataSourceInterface
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import java.util.concurrent.Executors

class MovieRemoteDataSource(private val networkConfig: NetworkConfig) : MovieDataSourceInterface {

    companion object {
        private val TAG = MovieRemoteDataSource::class.java.simpleName
    }

    override fun getMovies(): MutableLiveData<ApiResponse<GetMoviesResponse?>> {
        return call(networkConfig.getApiService().getMovies())
    }

    override fun getMovieDetail(id: Int): MutableLiveData<ApiResponse<GetMovieDetailResponse?>> {
        return call(networkConfig.getApiService().getMovieDetail(id))
    }

//    override fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
//        return call(networkConfig.getApiService().getTVShows())
//    }
//
//    override fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
//        return call(networkConfig.getApiService().getTVShowDetail(id))
//    }

    private fun incrementIdlingResource() {
        EspressoIdlingResource.increment()
    }

    private fun decrementIdlingResource() {
        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
            EspressoIdlingResource.decrement()
        }
    }

    private fun <T> call(call: Call<T>): MutableLiveData<ApiResponse<T?>> {
        incrementIdlingResource()
        val returnVal = MutableLiveData<ApiResponse<T?>>()

        Executors.newFixedThreadPool(5).execute {
            val response = call.execute()

            if (response.isSuccessful) {
                returnVal.postValue(ApiResponse.success(response.body()))
            } else {
                Log.e(TAG, "Error: " + response.errorBody()?.string())
                returnVal.postValue(null)
            }
            decrementIdlingResource()
        }

        return returnVal
    }
}