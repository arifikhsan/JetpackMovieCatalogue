package com.arifikhsan.jetpackmoviecatalogue.injection

import com.arifikhsan.jetpackmoviecatalogue.ui.favorite.FavoriteViewModel
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.MoviesViewModel
import com.arifikhsan.jetpackmoviecatalogue.ui.movies.detail.DetailMovieViewModel
import com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.TVShowsViewModel
import com.arifikhsan.jetpackmoviecatalogue.ui.tv_shows.detail.DetailTVShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }

    viewModel { TVShowsViewModel(get()) }
    viewModel { DetailTVShowViewModel(get()) }

    viewModel { FavoriteViewModel() }
}