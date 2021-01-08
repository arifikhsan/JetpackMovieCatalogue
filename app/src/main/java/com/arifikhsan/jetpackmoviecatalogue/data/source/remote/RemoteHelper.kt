package com.arifikhsan.jetpackmoviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arifikhsan.jetpackmoviecatalogue.util.EspressoIdlingResource
import retrofit2.Call
import java.util.concurrent.Executors

object RemoteHelper {
    private val TAG = RemoteHelper::class.java.simpleName

    fun <T> call(call: Call<T>): LiveData<ApiResponse<T>> {
        EspressoIdlingResource.increment()
        val returnVal = MutableLiveData<ApiResponse<T>>()

        Executors.newFixedThreadPool(5).execute {
            val response = call.execute()

            if (response.isSuccessful) {
                response.body()?.let {
                    returnVal.postValue(ApiResponse.success(it))
                }
            } else {
                Log.e(TAG, "Error: " + response.errorBody()?.string())
                returnVal.postValue(null)
            }

            decrementIdlingResource()
        }

        return returnVal
    }

    private fun decrementIdlingResource() {
        if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
            EspressoIdlingResource.decrement()
        }
    }
}