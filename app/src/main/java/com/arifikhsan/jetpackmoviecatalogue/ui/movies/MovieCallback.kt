package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import com.arifikhsan.jetpackmoviecatalogue.data.response.MovieResultsItem

interface MovieCallback {
    fun onShareClick(movie: MovieResultsItem?)
}