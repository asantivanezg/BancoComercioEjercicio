package com.banco.comercio.data.datasource

import com.banco.comercio.data.datasource.rest.entities.UserRestEntity
import com.banco.comercio.util.Resource

interface IUserDataStore {
    suspend fun getUserList(): Resource<List<UserRestEntity>>
}