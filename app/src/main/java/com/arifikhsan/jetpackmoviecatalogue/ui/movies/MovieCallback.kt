package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response.MovieResultsItem

interface MovieCallback {
    fun onShareClick(movie: MovieResultsItem?)
}