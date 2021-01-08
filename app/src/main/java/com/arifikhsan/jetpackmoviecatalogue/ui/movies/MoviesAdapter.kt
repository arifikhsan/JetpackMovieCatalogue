package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.ItemMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.MovieDetailActivity
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.MovieDetailActivity.Companion.EXTRA_MOVIE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter(private val callback: MovieCallback) :
    PagedListAdapter<MovieEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let { holder.bind(it) }
    }

    inner class MoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity?) {
            with(binding) {
                tvItemTitle.text = movie?.title
                tvItemDate.text = movie?.releaseDate

                tvRate.text = itemView.resources.getString(
                    R.string.rate_from,
                    movie?.voteAverage,
                    movie?.voteCount
                )

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${movie?.posterPath}")
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                    intent.putExtra(EXTRA_MOVIE, movie?.id)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener { callback.onShareClick(movie) }
            }
        }
    }
}