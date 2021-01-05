package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowsResponse

class TVShowsViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    var tvShows = MutableLiveData<GetTVShowsResponse?>()

    fun getTVShows() {
        tvShows = movieRepository.getTVShows()
    }
}