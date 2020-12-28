package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityDetailTvShowBinding
import com.arifikhsan.jetpackmoviecatalogue.databinding.ContentDetailTvShowBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTVShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var tvShow: GetTVShowDetailResponse

    private val detailTVShowViewModel: DetailTVShowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailTvShow
        setContentView(activityDetailTvShowBinding.root)

        initData()
        initView()
    }

    private fun initData() {
        intent.extras?.let {
            val tvShowId = it.getInt(EXTRA_TV_SHOW)
            detailTVShowViewModel.setTVShowId(tvShowId)
            detailTVShowViewModel.getTVShowDetail()?.let { detail -> tvShow = detail }

            populateDetail()
        }
    }

    private fun initView() {
        supportActionBar?.title = getString(R.string.detail_tv_show)
        supportActionBar?.subtitle = tvShow.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun populateDetail() {
        detailTvShowBinding.tvName.text = tvShow.name
        detailTvShowBinding.tvDate.text = tvShow.firstAirDate
        detailTvShowBinding.tvOverview.text = tvShow.overview
        detailTvShowBinding.tvRating.text =
            resources.getString(R.string.rate_from, tvShow.voteAverage?.toFloat(), tvShow.voteCount)

        Glide.with(this)
            .load(tvShow.posterPath)
            .transform(RoundedCorners(16))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailTvShowBinding.imagePoster)
    }
}