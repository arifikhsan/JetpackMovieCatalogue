package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

class TVShowDetailViewModel(private val repository: TVShowRepository) : ViewModel() {
    private var id = MutableLiveData<Int>()

    fun setTVShowId(id: Int) {
        this.id.value = id
    }

    var tvShow: LiveData<Resource<TVShowEntity>> =
        Transformations.switchMap(id) { mId ->
            repository.getTVShow(mId)
        }

    fun setFavorite() {
        val tvShowResource = tvShow.value

        if (tvShowResource != null) {
            val tvShowData = tvShowResource.data

            tvShowData?.let {
                repository.setFavoriteMovie(it, !it.favorite)
            }
        }
    }
}