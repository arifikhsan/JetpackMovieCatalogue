package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository

class TVShowsViewModel : ViewModel() {
    fun getTVShows(): ArrayList<TVShowEntity> = MovieRepository.getTVShows()
}