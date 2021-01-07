package com.arifikhsan.jetpackmoviecatalogue.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity
import com.arifikhsan.jetpackmoviecatalogue.valueobject.Resource

interface TVShowRepositoryInterface {
    fun getTVShows(): LiveData<Resource<PagedList<TVShowEntity>>>
    fun getTVShow(id: Int): LiveData<Resource<TVShowEntity>>
}
