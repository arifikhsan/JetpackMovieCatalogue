package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository

class TVShowsViewModel(private val repository: TVShowRepository) : ViewModel() {
    fun getTVShows() = repository.getTVShows()
}