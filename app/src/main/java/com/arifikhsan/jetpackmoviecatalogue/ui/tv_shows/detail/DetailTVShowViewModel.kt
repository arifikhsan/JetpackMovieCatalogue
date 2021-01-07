package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

class DetailTVShowViewModel(private val repository: TVShowRepository) : ViewModel() {
    lateinit var tvShow: LiveData<Resource<TVShowEntity>>
    private var id: Int = 0

    fun setTVShowId(id: Int) {
        this.id = id
    }

    fun getTVShowDetail() {
        tvShow = repository.getTVShow(id)
    }
}