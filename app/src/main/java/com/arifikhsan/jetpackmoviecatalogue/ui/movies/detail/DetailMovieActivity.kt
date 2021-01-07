package com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetMovieDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityDetailMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.databinding.ContentDetailMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailMovieBinding: ContentDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailMovieBinding = activityDetailMovieBinding.detailMovie
        setContentView(activityDetailMovieBinding.root)

        initView()
        initData()
    }

    private fun initData() {
        intent.extras?.let {
            val movieId = it.getInt(EXTRA_MOVIE)

            detailMovieViewModel.setMovieId(movieId)
            detailMovieViewModel.getMovieDetail()
//            detailMovieViewModel.movie.observe(this, { movie -> populateDetail(movie) })
        }
    }

    private fun initView() {
        supportActionBar?.title = getString(R.string.detail_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun populateDetail(movie: GetMovieDetailResponse?) {
        supportActionBar?.subtitle = movie?.title

        detailMovieBinding.tvTitle.text = movie?.title
        detailMovieBinding.tvDate.text = movie?.releaseDate
        detailMovieBinding.tvOverview.text = movie?.overview
        detailMovieBinding.tvRating.text =
            resources.getString(R.string.rate_from, movie?.voteAverage?.toFloat(), movie?.voteCount.toString())

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${movie?.posterPath}")
            .transform(RoundedCorners(16))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailMovieBinding.imagePoster)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}