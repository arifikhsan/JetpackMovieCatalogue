package com.arifikhsan.jetpackmoviecatalogue.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.databinding.FavoriteFragmentBinding
import com.arifikhsan.jetpackmoviecatalogue.ui.favorite.movies.FavoriteMoviesActivity
import com.arifikhsan.jetpackmoviecatalogue.ui.favorite.tv_shows.FavoriteTVShowsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private var _favoriteFragmentBinding: FavoriteFragmentBinding? = null
    private val binding get() = _favoriteFragmentBinding

    private val viewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteFragmentBinding = FavoriteFragmentBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        binding?.progressBarMovies?.visibility = View.VISIBLE
        binding?.progressBarTvShows?.visibility = View.VISIBLE

        viewModel.getFavoriteMoviesCount().observe(viewLifecycleOwner, {
            binding?.progressBarMovies?.visibility = View.GONE
            binding?.tvMoviesCount?.text = getString(R.string.text_count_item, it)
        })
        viewModel.getFavoriteTVShowsCount().observe(viewLifecycleOwner, {
            binding?.progressBarTvShows?.visibility = View.GONE
            binding?.tvTvShowCount?.text = getString(R.string.text_count_item, it)
        })

        binding?.cardMovies?.setOnClickListener {
            val intent = Intent(context, FavoriteMoviesActivity::class.java)
            startActivity(intent)
        }
        binding?.cardTvShows?.setOnClickListener {
            val intent = Intent(context, FavoriteTVShowsActivity::class.java)
            startActivity(intent)
        }
    }
}