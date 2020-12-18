package com.arifikhsan.jetpackmoviecatalogue.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityHomeBinding
import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository

class HomeActivity : AppCompatActivity() {
    companion object {
        private val TAG = HomeActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initData()
    }

    private fun initView() {
        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.subtitle = getString(R.string.app_subtitle)
        supportActionBar?.elevation = 0f
    }

    private fun initData() {
        val movies = MovieRepository.getMovies()
        val tvShows = MovieRepository.getTVShows()
    }
}