package com.arifikhsan.jetpackmoviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository
import com.beust.klaxon.Klaxon
import java.util.*

class HomeActivity : AppCompatActivity() {
    companion object {
        private val TAG = HomeActivity::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val movies = MovieRepository.getMovies()
    }
}