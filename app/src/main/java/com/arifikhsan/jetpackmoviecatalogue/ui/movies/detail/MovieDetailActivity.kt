package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityDetailMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.util.Notification
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private var _activityDetailMovieBinding: ActivityDetailMovieBinding? = null

    private val mainBinding get() = _activityDetailMovieBinding
    private val movieBinding get() = mainBinding?.detailMovie

    private val viewModel: MovieDetailViewModel by viewModel()
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)

        initView()
        initData()
    }

    private fun initView() {
        supportActionBar?.title = getString(R.string.detail_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initData() {
        intent.extras?.let {
            val movieId = it.getInt(EXTRA_MOVIE)

            viewModel.setMovieId(movieId)
            viewModel.movie.observe(this, { movieResource ->
                if (movieResource != null) {
                    when (movieResource.status) {
                        Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> movieResource.data?.let { movie ->
                            mainBinding?.progressBar?.visibility = View.GONE
                            mainBinding?.movie?.visibility = View.VISIBLE

                            populateDetail(movie)
                        }
                        Status.ERROR -> {
                            mainBinding?.progressBar?.visibility = View.GONE
                            Notification.showToast(this, "Terjadi kesalahan")
                        }
                    }
                }
            })
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        _activityDetailMovieBinding = null
        finish()
    }

    private fun populateDetail(movie: MovieEntity) {
        supportActionBar?.subtitle = movie.title

        with(movieBinding) {
            this?.tvTitle?.text = movie.title
            this?.tvDate?.text = movie.releaseDate
            this?.tvOverview?.text = movie.overview

            this?.tvRating?.text =
                resources.getString(
                    R.string.rate_from,
                    movie.voteAverage.toFloat(),
                    movie.voteCount
                )

            this?.let {
                Glide.with(this@MovieDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                    .transform(RoundedCorners(16))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(it.imagePoster)
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu

        viewModel.movie.observe(this, { movieResource ->
            if (movieResource != null) {
                when (movieResource.status) {
                    Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> movieResource.data?.let {
                        val state = it.favorite
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        mainBinding?.progressBar?.visibility = View.GONE
                        Notification.showToast(this, "Terjadi kesalahan")
                    }
                }
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                viewModel.setFavorite()
                showNotification()
                return true
            }
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        menu?.let {
            val menuItem = it.findItem(R.id.action_favorite)

            if (state) {
                menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited_white)
            } else {
                menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
            }
        }
    }

    private fun showNotification() {
        val isFavorite = viewModel.movie.value?.data?.favorite ?: false
        val message: String
        message = if (isFavorite) {
            "Menghapus dari favorit..."
        } else {
            "Menambahkan ke favorit..."
        }
        mainBinding?.root?.let { Notification.showSnackbar(it, message) }
    }
}
