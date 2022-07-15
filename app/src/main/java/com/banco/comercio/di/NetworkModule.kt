package com.banco.comercio.di

import com.banco.comercio.data.datasource.IUserDataStore
import com.banco.comercio.data.datasource.rest.store.RestUserDataStore
import com.banco.comercio.data.repository.UserDataRepository
import com.banco.comercio.domain.repository.IUserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindUserDataStore(userDataStore: RestUserDataStore): IUserDataStore

    @Binds
    abstract fun bindUserDataRepository(userDataRepository: UserDataRepository): IUserDataRepository
}