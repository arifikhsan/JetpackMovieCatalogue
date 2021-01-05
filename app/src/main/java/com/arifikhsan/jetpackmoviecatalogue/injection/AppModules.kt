package com.arifikhsan.jetpackmoviecatalogue.injection

import com.arifikhsan.jetpackmoviecatalogue.data.repository.MovieRepository
import com.arifikhsan.jetpackmoviecatalogue.data.source.local.room.MovieDao
import com.arifikhsan.jetpackmoviecatalogue.data.source.remote.MovieRemoteDataSource
import com.arifikhsan.jetpackmoviecatalogue.network.NetworkConfig
import org.koin.dsl.module

val appModules = module {
    single { NetworkConfig() }
    single { MovieRemoteDataSource(get()) }
    single { MovieRepository(get()) }
}