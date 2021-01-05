package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.GetTVShowDetailResponse

class DetailTVShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    lateinit var tvShow: LiveData<GetTVShowDetailResponse?>
    private var id: Int = 0

    fun setTVShowId(id: Int) {
        this.id = id
    }

    fun getTVShowDetail() {
        tvShow = movieRepository.getTVShowDetail(id)
    }
}