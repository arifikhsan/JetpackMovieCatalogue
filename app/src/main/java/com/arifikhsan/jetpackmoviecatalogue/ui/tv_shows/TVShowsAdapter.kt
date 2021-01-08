package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ItemMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail.TVShowDetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TVShowsAdapter(private val callback: TVShowCallback) :
    PagedListAdapter<TVShowEntity, TVShowsAdapter.TVShowsViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShowEntity>() {
            override fun areItemsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TVShowEntity, newItem: TVShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowsViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        val tvShow = getItem(position)
        tvShow?.let { holder.bind(it) }
    }

    inner class TVShowsViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TVShowEntity?) {
            with(binding) {
                tvItemTitle.text = tvShow?.name
                tvItemDate.text = tvShow?.firstAirDate

                tvRate.text = itemView.resources.getString(
                    R.string.rate_from,
                    tvShow?.voteAverage,
                    tvShow?.voteCount
                )

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${tvShow?.posterPath}")
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, TVShowDetailActivity::class.java)
                    intent.putExtra(TVShowDetailActivity.EXTRA_TV_SHOW, tvShow?.id)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener { callback.onShareClick(tvShow) }
            }
        }
    }
}