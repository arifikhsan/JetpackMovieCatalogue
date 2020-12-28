package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import com.arifikhsan.jetpackmoviecatalogue.data.response.TVShowResultsItem

interface TVShowCallback {
    fun onShareClick(tvShow: TVShowResultsItem?)
}