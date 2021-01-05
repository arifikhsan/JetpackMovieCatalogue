package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetMoviesResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.MovieDataSourceInterface
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class MovieRemoteDataSource(private val networkConfig: NetworkConfig) :
    MovieDataSourceInterface {

    companion object {
        private val TAG = MovieRemoteDataSource::class.java.simpleName
    }

    private fun incrementIdlingResource() {
        EspressoIdlingResource.increment()
    }

    private fun decrementIdlingResource() {
        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
            EspressoIdlingResource.decrement()
        }
    }

    private fun <T> call(call: Call<T>): MutableLiveData<T?> {
        incrementIdlingResource()

        val returnVal = MutableLiveData<T?>()
        Executors.newFixedThreadPool(5).execute {
            val response = call.execute()
            if (response.isSuccessful) {
                returnVal.postValue(response.body())
            } else {
                Log.e(TAG, "Error: " + response.errorBody()?.string())
                returnVal.postValue(null)
            }
            decrementIdlingResource()
        }
        return returnVal
    }

    override fun getMovies(): MutableLiveData<GetMoviesResponse?> {
        return call(networkConfig.getApiService().getMovies())
    }

    override fun getMovieDetail(id: Int): MutableLiveData<GetMovieDetailResponse?> {
        return call(networkConfig.getApiService().getMovieDetail(id))
    }

    override fun getTVShows(): MutableLiveData<GetTVShowsResponse?> {
        return call(networkConfig.getApiService().getTVShows())
    }

    override fun getTVShowDetail(id: Int): MutableLiveData<GetTVShowDetailResponse?> {
        return call(networkConfig.getApiService().getTVShowDetail(id))
    }
}