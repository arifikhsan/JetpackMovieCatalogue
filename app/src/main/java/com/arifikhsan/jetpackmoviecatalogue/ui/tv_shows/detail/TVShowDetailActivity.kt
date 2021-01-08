package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ActivityDetailTvShowBinding
import com.arifikhsan.jetpackmoviecatalogue.util.Notification
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class TVShowDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private var _activityDetailTvShowBinding: ActivityDetailTvShowBinding? = null

    private val mainBinding get() = _activityDetailTvShowBinding
    private val tvShowBinding get() = mainBinding?.detailTvShow

    private val detailViewModel: TVShowDetailViewModel by viewModel()
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)

        initView()
        initData()
    }

    private fun initView() {
        supportActionBar?.title = getString(R.string.detail_tv_show)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initData() {
        intent.extras?.let {
            val tvShowId = it.getInt(EXTRA_TV_SHOW)

            detailViewModel.setTVShowId(tvShowId)
            detailViewModel.tvShow.observe(this, { tvShowResource ->
                if (tvShowResource != null) {
                    when (tvShowResource.status) {
                        Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> tvShowResource.data?.let { tvShow ->
                            mainBinding?.progressBar?.visibility = View.GONE
                            mainBinding?.tvShow?.visibility = View.VISIBLE

                            populateDetail(tvShow)
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

    private fun populateDetail(tvShow: TVShowEntity) {
        supportActionBar?.subtitle = tvShow.name

        with(tvShowBinding) {
            this?.tvName?.text = tvShow.name
            this?.tvDate?.text = tvShow.firstAirDate
            this?.tvOverview?.text = tvShow.overview

            this?.tvRating?.text =
                resources.getString(
                    R.string.rate_from,
                    tvShow.voteAverage.toFloat(),
                    tvShow.voteCount
                )

            this?.let {
                Glide.with(this@TVShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${tvShow.posterPath}")
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

        detailViewModel.tvShow.observe(this, { tvShowResource ->
            if (tvShowResource != null) {
                when (tvShowResource.status) {
                    Status.LOADING -> mainBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> tvShowResource.data?.let {
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
        if (item.itemId == R.id.action_favorite) {
            detailViewModel.setFavorite()
            showNotification()
            return true
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
        val isFavorite = detailViewModel.tvShow.value?.data?.favorite ?: false
        val message: String
        message = if (isFavorite) {
            "Menghapus dari favorit..."
        } else {
            "Menambahkan ke favorit..."
        }
        mainBinding?.root?.let { Notification.showSnackbar(it, message) }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        _activityDetailTvShowBinding = null
        finish()
    }
}