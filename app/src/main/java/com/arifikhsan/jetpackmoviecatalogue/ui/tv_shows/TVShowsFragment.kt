package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.databinding.FragmentTvShowsBinding
import com.arifikhsan.jetpackmoviecatalogue.util.Notification
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class TVShowsFragment : Fragment(), TVShowCallback {

    private var _fragmentTVShowsBinding: FragmentTvShowsBinding? = null
    private val binding get() = _fragmentTVShowsBinding

    private val viewModel: TVShowsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentTVShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val adapter = TVShowsAdapter(this)

            viewModel.getTVShows().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            adapter.submitList(tvShows.data)
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Notification.showToast(context, "Terjadi kesalahan")
                        }
                    }
                }
            })

            with(binding?.rvTvShows) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }
    }

    override fun onShareClick(tvShow: TVShowEntity?) {
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

    override fun onDestroy() {
        super.onDestroy()
        _fragmentTVShowsBinding = null
    }
}