package com.arifikhsan.jetpackmoviecatalogue.ui.favorite.movies

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityFavoriteMoviesBinding
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.MovieCallback
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.MoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteMoviesActivity : AppCompatActivity(), MovieCallback {

    private var _favoriteMoviesBinding: ActivityFavoriteMoviesBinding? = null
    private val binding get() = _favoriteMoviesBinding

    private val viewModel: FavoriteMoviesViewModel by viewModel()
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _favoriteMoviesBinding = ActivityFavoriteMoviesBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initView()
    }

    private fun initView() {
        supportActionBar?.title = "Favorite Movies"
        adapter = MoviesAdapter(this)

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteMovies().observe(this, {
            binding?.progressBar?.visibility = View.GONE
            adapter.submitList(it)
        })
        binding?.rvMovies?.layoutManager = LinearLayoutManager(this)
        binding?.rvMovies?.setHasFixedSize(true)
        binding?.rvMovies?.adapter = adapter
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

    override fun onShareClick(movie: MovieEntity?) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(getString(R.string.share_title))
            .setText(resources.getString(R.string.share_text, movie?.title))
            .startChooser()
    }
}