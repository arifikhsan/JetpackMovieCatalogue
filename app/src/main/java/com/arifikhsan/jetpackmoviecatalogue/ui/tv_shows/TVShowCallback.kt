package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.TVShowEntity

interface TVShowCallback {
    fun onShareClick(tvShow: TVShowEntity?)
}