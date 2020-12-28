package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.response.MovieResultsItem
import com.arifikhsan.jetpackmoviecatalogue.databinding.ItemMovieBinding
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.DetailMovieActivity
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.DetailMovieActivity.Companion.EXTRA_MOVIE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter(private val callback: MovieCallback) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val movies = ArrayList<MovieResultsItem?>()

    fun setMovies(movies: ArrayList<MovieResultsItem?>?) {
        movies?.let {
            this.movies.clear()
            this.movies.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class MoviesViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieResultsItem?) {
            with(binding) {
                tvItemTitle.text = movie?.title
                tvItemDate.text = movie?.releaseDate

                tvRate.text = itemView.resources.getString(
                    R.string.rate_from,
                    movie?.voteAverage,
                    movie?.voteCount
                )

                Glide.with(itemView.context)
                    .load(movie?.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(EXTRA_MOVIE, movie?.id)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener { callback.onShareClick(movie) }
            }
        }
    }
}