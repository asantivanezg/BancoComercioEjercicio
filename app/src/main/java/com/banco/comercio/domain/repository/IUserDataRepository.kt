package com.banco.comercio.domain.repository

import com.banco.comercio.domain.model.User
import com.banco.comercio.util.Resource

interface IUserDataRepository {
    suspend fun getUserList(): Resource<List<User>>
}