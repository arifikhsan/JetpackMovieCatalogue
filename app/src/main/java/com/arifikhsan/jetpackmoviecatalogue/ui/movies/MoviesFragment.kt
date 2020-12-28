package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifikhsan.jetpackmoviecatalogue.R
import com.arifikhsan.jetpackmoviecatalogue.data.response.MovieResultsItem
import com.arifikhsan.jetpackmoviecatalogue.databinding.FragmentMoviesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment(), MovieCallback {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            moviesViewModel.getMovies()

            moviesViewModel.movies.observe(viewLifecycleOwner, { movies ->
                val moviesAdapter = MoviesAdapter(this)
                movies?.results?.let { moviesAdapter.setMovies(ArrayList(it)) }

                with(fragmentMoviesBinding.rvMovies) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = moviesAdapter
                }
            })

        }
    }

    override fun onShareClick(movie: MovieResultsItem?) {
        activity?.let {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle(getString(R.string.share_title))
                .setText(resources.getString(R.string.share_text, movie?.title))
                .startChooser()
        }
    }
}