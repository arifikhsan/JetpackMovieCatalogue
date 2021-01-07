package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.model.MovieModel
import com.arifikhsan.jetpackmoviecatalogue.model.TVShowModel
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

interface TVShowRepositoryInterface {
    fun getTVShows(): LiveData<Resource<PagedList<TVShowModel>>>
    fun getTVShow(): LiveData<Resource<TVShowModel>>
}
