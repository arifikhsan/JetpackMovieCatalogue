package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowsResponse

class TVShowsViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTVShows(): GetTVShowsResponse? = movieRepository.getTVShows()
}