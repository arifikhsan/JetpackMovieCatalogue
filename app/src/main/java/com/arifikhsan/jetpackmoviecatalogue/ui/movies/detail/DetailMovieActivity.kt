package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityDetailMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private var _activityDetailMovieBinding: ActivityDetailMovieBinding? = null

    private val mainBinding get() = _activityDetailMovieBinding
    private val movieBinding get() = _activityDetailMovieBinding?.detailMovie

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
                when (movieResource.status) {
                    Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> movieResource.data?.let { movie ->
                        mainBinding?.progressBar?.visibility = View.GONE
                        mainBinding?.movie?.visibility = View.VISIBLE

                        populateDetail(movie)
                    }
                    Status.ERROR -> {
                        mainBinding?.progressBar?.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun populateDetail(movie: MovieEntity) {
        supportActionBar?.subtitle = movie.title

        movieBinding
        with(movieBinding) {
            this?.tvTitle?.text = movie.title
            this?.tvDate?.text = movie.releaseDate
            this?.tvRating?.text =
                resources.getString(
                    R.string.rate_from,
                    movie.voteAverage.toFloat(),
                    movie.voteCount
                )

            this?.let {
                Glide.with(this@DetailMovieActivity)
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
}
