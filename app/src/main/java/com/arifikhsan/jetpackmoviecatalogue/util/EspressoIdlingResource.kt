package com.arifikhsan.jetpackmoviecatalogue.util

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"
    private val idlingResource = CountingIdlingResource(RESOURCE)

      fun getEspressoIdlingResource(): IdlingResource {
        return idlingResource
    }

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}