package com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows

import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.TVShowResultsItem

interface TVShowCallback {
    fun onShareClick(tvShow: TVShowResultsItem?)
}