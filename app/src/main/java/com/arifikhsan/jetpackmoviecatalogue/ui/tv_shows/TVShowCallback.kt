package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import com.arifikhsan.jetpackmoviecatalogue.entity.TVShowEntity

interface TVShowCallback {
    fun onShareClick(tvShow: TVShowEntity)
}