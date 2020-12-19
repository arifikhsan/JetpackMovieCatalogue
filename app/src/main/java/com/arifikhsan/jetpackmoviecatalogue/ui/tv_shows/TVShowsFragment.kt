package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.databinding.FragmentTvShowsBinding
import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity

class TVShowsFragment : Fragment(), TVShowCallback {

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
            val tvShowsAdapter = TVShowsAdapter(this)
            tvShowsAdapter.setTVShows(tvShows)

            with(fragmentTVShowsBinding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

    override fun onShareClick(tvShow: TVShowEntity) {
        activity?.let {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle(getString(R.string.share_title))
                .setText(resources.getString(R.string.share_text, tvShow.name))
                .startChooser()
        }
    }
}