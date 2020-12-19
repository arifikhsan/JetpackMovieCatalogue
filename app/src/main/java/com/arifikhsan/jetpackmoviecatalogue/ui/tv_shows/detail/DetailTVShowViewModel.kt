package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.repository.MovieRepository

class DetailTVShowViewModel: ViewModel() {
    private var tvShowId: Int = 0

    fun setSelectedTVShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getTVShow(): TVShowEntity {
        val tvShows = MovieRepository.getTVShows()
        val tvShow: TVShowEntity?
        tvShow = tvShows.find { it.id == tvShowId }

        return tvShow ?: MovieRepository.getEmptyTVShow()
    }
}