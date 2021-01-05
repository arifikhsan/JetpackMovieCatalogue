package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.data.source.TVShowDatasourceInterface
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import java.util.concurrent.Executors

class TVShowRemoteDataSource(private val networkConfig: NetworkConfig) : TVShowDatasourceInterface {

    companion object {
        private val TAG = TVShowRemoteDataSource::class.java.simpleName
    }

    override fun getTVShows(): MutableLiveData<ApiResponse<GetTVShowsResponse?>> {
        return call(networkConfig.getApiService().getTVShows())
    }

    override fun getTVShowDetail(id: Int): MutableLiveData<ApiResponse<GetTVShowDetailResponse?>> {
        return call(networkConfig.getApiService().getTVShowDetail(id))
    }

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