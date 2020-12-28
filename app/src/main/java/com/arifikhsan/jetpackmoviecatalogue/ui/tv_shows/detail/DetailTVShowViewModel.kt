package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.response.GetTVShowDetailResponse

class DetailTVShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private var id: Int = 0

    fun setTVShowId(id: Int) {
        this.id = id
    }

    fun getTVShowDetail(): GetTVShowDetailResponse? {
        return movieRepository.getTVShowDetail(id)
    }
}