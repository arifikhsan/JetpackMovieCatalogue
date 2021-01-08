package com.arifikhsan.jetpackmoviecatalogue.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

object Notification {
    fun showSnackbar(view: View, message: String, length: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(view, message, length).show()
    }
}