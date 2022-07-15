package com.banco.comercio.data.repository

import com.banco.comercio.data.datasource.rest.store.RestUserDataStore
import com.banco.comercio.data.mapper.UserMapper
import com.banco.comercio.domain.model.User
import com.banco.comercio.domain.repository.IUserDataRepository
import com.banco.comercio.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepository @Inject constructor(private val repo: RestUserDataStore) : IUserDataRepository {
    override suspend fun getUserList(): Resource<List<User>> {
        val res = repo.getUserList()
        val mapper = UserMapper()
        return Resource(res.status, res.data?.let { mapper.mapperFromListWsToModel(it) }, res.message)
    }

}