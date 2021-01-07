package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import com.arifikhsan.jetpackmoviecatalogue.data.source.local.entity.MovieEntity

interface MovieCallback {
    fun onShareClick(movie: MovieEntity?)
}