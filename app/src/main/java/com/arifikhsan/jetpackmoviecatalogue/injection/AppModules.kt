package com.arifikhsan.jetpackmoviecatalogue.injection

import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.repository.TVShowRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.MovieLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.TVShowLocalDatasource
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.AppDatabase
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.TVShowRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.network.NetworkConfig
import com.arifikhsan.jetpackmoviecatalogue.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModules = module {
    factory { AppDatabase.getInstance(androidContext()) }

    single { NetworkConfig() }
    single { AppExecutors() }

    single { MovieRemoteDataSource(get()) }
    single { MovieLocalDatasource(get()) }

    single { TVShowRemoteDataSource(get()) }
    single { TVShowLocalDatasource(get()) }

    single { MovieRepository(get(), get(), get()) }
    single { TVShowRepository(get(), get(), get()) }
}