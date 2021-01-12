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
import com.arifikhsan.jetpackmoviecatalogue.util.DataDummy
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModules = module {
    // context
    factory { AppDatabase.getInstance(androidContext()) }

    // core
    single { NetworkConfig() }
    single { get<NetworkConfig>().getApiService() }
    single { AppExecutors() }

    // datasource
    single { MovieRemoteDataSource(get()) }
    single { MovieLocalDatasource(get()) }
    single { TVShowRemoteDataSource(get()) }
    single { TVShowLocalDatasource(get()) }

    // repository
    single { MovieRepository(get(), get(), get()) }
    single { TVShowRepository(get(), get(), get()) }

    // utils
    single { DataDummy() }
}