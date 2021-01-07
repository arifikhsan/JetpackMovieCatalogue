package com.arifikhsan.jetpackmoviecatalogue.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var _activityHomeBinding: ActivityHomeBinding? = null
    private val binding get() = _activityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        _activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)

        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.subtitle = getString(R.string.app_subtitle)
        supportActionBar?.elevation = 0f
    }

    override fun onBackPressed() {
        if (binding?.viewPager?.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding?.viewPager?.currentItem =
                binding?.viewPager?.currentItem?.minus(1)!!
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityHomeBinding = null
    }
}