package com.arifikhsan.jetpackmoviecatalogue.ui.movies

import com.arifikhsan.jetpackmoviecatalogue.entity.MovieEntity

interface MovieCallback {
    fun onShareClick(movie: MovieEntity)
}