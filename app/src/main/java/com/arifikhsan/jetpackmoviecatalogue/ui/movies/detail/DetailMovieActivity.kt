package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityDetailMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.databinding.ContentDetailMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var movie: MovieEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailMovie
        setContentView(activityDetailMovieBinding.root)
        initData()
        initView()
    }

    private fun initData() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        intent.extras?.let {
            val movieId = it.getInt(EXTRA_MOVIE)
            viewModel.setSelectedMovie(movieId)
            movie = viewModel.getMovie()
            populateDetail()
        }
    }

    private fun initView() {
        supportActionBar?.title = getString(R.string.detail_movie)
        supportActionBar?.subtitle = movie.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun populateDetail() {
        detailMovieBinding.tvTitle.text = movie.title
        detailMovieBinding.tvDate.text = movie.releaseDate
        detailMovieBinding.tvOverview.text = movie.overview
        detailMovieBinding.tvRating.text =
            resources.getString(R.string.rate_from, movie.voteAverage.toFloat(), movie.voteCount)

        Glide.with(this)
            .load(movie.posterPath)
            .transform(RoundedCorners(16))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailMovieBinding.imagePoster)
    }
}