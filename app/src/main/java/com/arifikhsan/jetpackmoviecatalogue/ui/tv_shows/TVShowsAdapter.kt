package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.databinding.ItemMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.DetailMovieActivity
import com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail.DetailTVShowActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TVShowsAdapter : RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder>() {

    private val tvShows = ArrayList<TVShowEntity>()

    fun setTVShows(shows: ArrayList<TVShowEntity>?) {
        shows?.let {
            tvShows.clear()
            tvShows.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowsViewHolder {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowsViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TVShowsViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    class TVShowsViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TVShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.name
                tvItemDate.text = tvShow.firstAirDate

                tvRate.text = itemView.resources.getString(
                    R.string.rate_from,
                    tvShow.voteAverage,
                    tvShow.voteCount
                )

                Glide.with(itemView.context)
                    .load(tvShow.posterPath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTVShowActivity::class.java)
                    intent.putExtra(DetailTVShowActivity.EXTRA_TV_SHOW, tvShow.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}