package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.response.TVShowResultsItem
import com.arifikhsan.jetpackmoviecatalogue.databinding.FragmentTvShowsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TVShowsFragment : Fragment(), TVShowCallback {

    private lateinit var fragmentTVShowsBinding: FragmentTvShowsBinding
    private val tvShowsViewModel: TVShowsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTVShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            tvShowsViewModel.getTVShows()
            tvShowsViewModel.tvShows.observe(viewLifecycleOwner, { responseTVShows ->
                val tvShowsAdapter = TVShowsAdapter(this)
                responseTVShows?.results?.let { tvShowsAdapter.setTVShows(ArrayList(it)) }

                with(fragmentTVShowsBinding.rvTvShows) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvShowsAdapter
                }
            })

        }
    }

    override fun onShareClick(tvShow: TVShowResultsItem?) {
        activity?.let {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle(getString(R.string.share_title))
                .setText(resources.getString(R.string.share_text, tvShow?.name))
                .startChooser()
        }
    }
}