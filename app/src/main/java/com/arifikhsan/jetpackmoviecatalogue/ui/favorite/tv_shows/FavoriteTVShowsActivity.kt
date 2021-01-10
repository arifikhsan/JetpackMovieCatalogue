package com.arifikhsan.jetpackmoviecatalogue.ui.favorite.tv_shows

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityFavoriteTvShowsBinding
import com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.TVShowCallback
import com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.TVShowsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteTVShowsActivity : AppCompatActivity(), TVShowCallback {

    private var _favoriteTVShowsBinding: ActivityFavoriteTvShowsBinding? = null
    private val binding get() = _favoriteTVShowsBinding

    private val viewModel: FavoriteTVShowsViewModel by viewModel()
    private lateinit var adapter: TVShowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _favoriteTVShowsBinding = ActivityFavoriteTvShowsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initView()
    }

    private fun initView() {
        supportActionBar?.title = "Favorite TV Shows"
        adapter = TVShowsAdapter(this)

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteTVShows().observe(this, {
            binding?.progressBar?.visibility = View.GONE
            adapter.submitList(it)
        })
        binding?.rvTvShows?.layoutManager = LinearLayoutManager(this)
        binding?.rvTvShows?.setHasFixedSize(true)
        binding?.rvTvShows?.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onShareClick(tvShow: TVShowEntity?) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(getString(R.string.share_title))
            .setText(resources.getString(R.string.share_text, tvShow?.name))
            .startChooser()
    }
}