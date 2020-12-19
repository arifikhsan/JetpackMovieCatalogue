package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.databinding.FragmentTvShowsBinding

class TVShowsFragment : Fragment() {

    private lateinit var fragmentTVShowsBinding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTVShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVShowsViewModel::class.java]
            val tvShows = viewModel.getTVShows()
            val tvShowsAdapter = TVShowsAdapter()
            tvShowsAdapter.setTVShows(tvShows)

            with(fragmentTVShowsBinding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }
}